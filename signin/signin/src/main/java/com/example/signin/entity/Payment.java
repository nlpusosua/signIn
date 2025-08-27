package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.security.Timestamp;

@Entity
@Table(name = "payments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentType payment_type;

    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private Timestamp paid_at;
    private String notes;
    private Timestamp created_at;

    public enum PaymentType {
        deposit, rental, late_fee, damage_fee
    }

    public enum PaymentMethod {
        cash, credit_card, bank_transfer, e_wallet
    }

    public enum PaymentStatus {
        pending, completed, failed
    }
}

