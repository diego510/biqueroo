package com.example.biquerito.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Publication post;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime datetime;

    @Column(name = "status", nullable = false)
    private boolean status;

    public Notification() {
    }

    public Notification(User user, Publication post, String content, LocalDateTime datetime, boolean status) {
        this.user = user;
        this.post = post;
        this.content = content;
        this.datetime = datetime;
        this.status = status;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Publication getPost() {
        return post;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public boolean getStatus() {
        return status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPost(Publication post) {
        this.post = post;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
