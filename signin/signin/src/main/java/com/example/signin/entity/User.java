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

    public enum Role {
        ADMIN, OWNER, RENTER
    }
}
