package com.example.biquerito.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chatId", nullable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "user1Id", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2Id", nullable = false)
    private User user2;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "dateandtime", nullable = false)
    private LocalDateTime dateandtime;

    @Column(name = "status", nullable = false)
    private boolean status;

    public Message() {
    }

    public Message(Chat chat, User user1, User user2, String content, LocalDateTime dateandtime, boolean status) {
        this.chat = chat;
        this.user1 = user1;
        this.user2 = user2;
        this.content = content;
        this.dateandtime = dateandtime;
        this.status = status;
    }

    public Chat getChat() {
        return chat;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateandtime() {
        return dateandtime;
    }

    public boolean getStatus() {
        return status;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateandtime(LocalDateTime dateandtime) {
        this.dateandtime = dateandtime;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}