package com.example.biquerito.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1Id", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2Id", nullable = false)
    private User user2;

    @Transient
    private Long userIdTransient;

    // Getters, setters, and constructors
}
