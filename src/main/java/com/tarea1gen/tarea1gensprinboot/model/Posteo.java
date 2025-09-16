package com.tarea1gen.tarea1gensprinboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posteos")
public class Posteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    @JsonBackReference
    private Author persona;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    public Posteo() {
    }

    public Posteo(Long id, String titulo, Author persona) {
        this.id = id;
        this.titulo = titulo;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Author getPersona() {
        return persona;
    }

    public void setPersona(Author persona) {
        this.persona = persona;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    @Override
    public String toString() {
        return "Posteo{id=" + id + ", titulo='" + titulo + "', authorId=" + (persona != null ? persona.getId() : null) + "}";
    }
}
