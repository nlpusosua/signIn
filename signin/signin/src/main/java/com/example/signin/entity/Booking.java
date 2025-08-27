package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Item
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    // Renter
    @ManyToOne
    @JoinColumn(name = "renter_id")
    private User renter;

    // Owner
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private Integer rental_hours;
    private BigDecimal deposit_amount;
    private BigDecimal damage_fee;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payment_status;

    private String notes;
    private String cancellation_reason;
    private Timestamp created_at;
    private Timestamp updated_at;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Payment> payments;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public enum Status {
        pending, confirmed, cancelled, completed
    }

    public enum PaymentStatus {
        unpaid, paid, refunded
    }
}

