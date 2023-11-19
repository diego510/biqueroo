package com.example.biquerito.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "reaccion")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "publicationId", nullable = false)
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Transient
    private Long userIdTransient;

    @Transient
    private Long publicationIdTransient;

    @Column(name = "rtype", nullable = false)
    private String rtype;

    @Column(name = "comentary")
    private String comentary;

    public Reaction() {
    }

    public Reaction(Publication publication, User user, String rtype, String comentary) {
        this.publication = publication;
        this.user = user;
        this.rtype = rtype;
        this.comentary = comentary;
    }

    public Long getId() {
        return id;
    }

    public Publication getPublication() {
        return publication;
    }

    public User getUser() {
        return user;
    }

    public String getRtype() {
        return rtype;
    }

    public String getComentary() {
        return comentary;
    }

    public Long getUserIdTransient() {
        return userIdTransient;
    }

    public Long getPublicationIdTransient() {
        return publicationIdTransient;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTipo(String rtype) {
        this.rtype = rtype;
    }

    public void setComentario(String comentary) {
        this.comentary = comentary;
    }

}