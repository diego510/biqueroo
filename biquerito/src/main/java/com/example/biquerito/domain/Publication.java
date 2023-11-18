package com.example.biquerito.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "publications")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Transient
    private Long userIdTransient;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "file")
    private String file;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    public Publication() {
    }

    public Publication(User user, String category, String title, String description, String file) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.description = description;
        this.file = file;
    }

    // Getters and setters for existing fields

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getFile() {
        return file;
    }

    public Long getUserIdTransient() {
        return userIdTransient;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFile(String file) {
        this.file = file;
    }

    // Getters and setters for the new relationship

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
