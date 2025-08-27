package com.example.signin.entity;

import jakarta.persistence.*;
import lombok.*;
import java.security.Timestamp;

@Entity
@Table(name = "chat_messages")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn(name = "conversation_id")
    private ChatConversation conversation;

    @ManyToOne @JoinColumn(name = "sender_id")
    private User sender;

    private String message;

    @Enumerated(EnumType.STRING)
    private MessageType message_type;

    private String attachment_url;
    private Boolean is_read;
    private Timestamp read_at;
    private Timestamp created_at;

    public enum MessageType {
        text, image, file
    }
}

