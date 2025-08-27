package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;
import java.security.Timestamp;

@Entity
@Table(name = "reviews")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne @JoinColumn(name = "reviewer_id")
    private User reviewer;

    @ManyToOne @JoinColumn(name = "reviewed_id")
    private User reviewed;

    private Integer rating;
    private String review;
    private Timestamp created_at;
}

