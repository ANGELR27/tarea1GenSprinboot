package com.tarea1gen.tarea1gensprinboot.service;

import com.tarea1gen.tarea1gensprinboot.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findAllAuthor();
    Author findAuthorById(Long id);
    Author save(Author author);
    Author updateAuthor(Author author);
    Author deleteAuthor(Long id);
}
