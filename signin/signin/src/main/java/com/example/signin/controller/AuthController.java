package com.example.signin.controller;

import com.example.signin.dto.LoginRequest;
import com.example.signin.dto.LoginResponse;
import com.example.signin.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Với JWT: logout = client xoá token
        return ResponseEntity.ok("Logged out successfully (delete token on client)");
    }
}
