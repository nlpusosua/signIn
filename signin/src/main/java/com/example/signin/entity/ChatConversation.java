package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;
import java.security.Timestamp;
import java.util.List;
@Entity
@Table(name = "chat_conversations")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ChatConversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne @JoinColumn(name = "participant1_id")
    private User participant1;

    @ManyToOne @JoinColumn(name = "participant2_id")
    private User participant2;

    private Timestamp last_message_at;
    private Timestamp created_at;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL)
    private List<ChatMessage> messages;
}

