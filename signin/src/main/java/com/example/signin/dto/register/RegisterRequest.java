package com.example.signin.dto.register;

import com.example.signin.entity.User;
import lombok.Getter;

import javax.management.relation.Role;

public class RegisterRequest {
    @Getter
    private String email;
    private String password;
    private String name;
    private String phone;
    @Getter
    private User.Role role;

    public User.Role getRole() {
        return role;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        this.phone = phone;
        return null;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
