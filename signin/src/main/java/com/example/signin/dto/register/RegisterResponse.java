package com.example.signin.dto.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse {
    private String token;
    public RegisterResponse(String token) { this.token = token; }
}
