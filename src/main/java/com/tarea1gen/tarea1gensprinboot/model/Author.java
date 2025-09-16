package com.tarea1gen.tarea1gensprinboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    @Email(message = "El email debe ser valido")
    String email;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Posteo> posteos = new ArrayList<>();


    public Author() {
    }

    public Author(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Author{id=" + id + ", Name='" + name + "', Email='" + email + "'}";
    }
}

