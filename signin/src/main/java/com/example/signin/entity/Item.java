package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.List;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Owner (user)
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String name;

    @Column(columnDefinition = "json")
    private String description;

    private BigDecimal price;
    private BigDecimal late_price;
    private BigDecimal deposit_amount;
    private Integer amount;
    private String address;
    private Integer condition_rating;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availability_status;

    private Boolean is_active;
    private Timestamp created_at;
    private Timestamp updated_at;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<ItemImage> images;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public enum AvailabilityStatus {
        available, unavailable, maintenance
    }
}

