package com.example.signin.service;

import com.example.signin.dto.login.LoginRequest;
import com.example.signin.dto.login.LoginResponse;
import com.example.signin.dto.register.RegisterRequest;
import com.example.signin.dto.register.RegisterResponse;
import com.example.signin.entity.User;
import com.example.signin.repository.UserRepository;
import com.example.signin.security.JwtTokenUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       JwtTokenUtil jwtTokenUtil,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(RegisterRequest request){
        Optional<User> exitUser = userRepository.findByEmail(request.getEmail());
        if (exitUser.isPresent()){
            throw new RuntimeException(" Email da duoc su dung");
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(encodedPassword);
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());
        user.setIs_active(true);
        userRepository.save(user);

        String token = jwtTokenUtil.generateToken(user.getEmail());
        return new RegisterResponse(token);
    }
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtTokenUtil.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}
