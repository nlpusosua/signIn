package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String identity_card;
    private String avatar;
    private Boolean is_active;
    private java.sql.Timestamp created_at;
    private java.sql.Timestamp updated_at;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setIs_active(Boolean isActive) {
        this.is_active = isActive;
    }

    public enum Role {
        ADMIN, OWNER, RENTER
    }
}
