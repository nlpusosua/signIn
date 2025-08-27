package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String message;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Boolean is_read;
    private Boolean is_sent;
    private Timestamp created_at;
    private Timestamp read_at;

    public enum Type {
        system, booking, payment, review, chat
    }
}
