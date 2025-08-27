package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@Entity
@Table(name = "item_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private String image_url;

    @Enumerated(EnumType.STRING)
    private ImageType image_type;

    private Timestamp created_at;

    public enum ImageType {
        main, extra
    }
}

