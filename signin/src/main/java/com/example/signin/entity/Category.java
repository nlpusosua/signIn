package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.security.Timestamp;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Boolean is_active;
    private Timestamp created_at;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Item> items;
}

