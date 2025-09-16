package com.tarea1gen.tarea1gensprinboot.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

    @Id
    Long id;
    String text;

}
