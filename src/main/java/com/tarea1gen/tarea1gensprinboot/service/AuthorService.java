package com.tarea1gen.tarea1gensprinboot.service;

import com.tarea1gen.tarea1gensprinboot.model.Author;
import com.tarea1gen.tarea1gensprinboot.repository.IAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthor authorRepo;

    @Override
    public List<Author> findAllAuthor() {
        return authorRepo.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepo.findById(id).orElse(null);
    }

    @Override
    public Author save(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        if (author.getId() == null || !authorRepo.existsById(author.getId())) {
            return null;
        }
        return authorRepo.save(author);
    }

    @Override
    public Author deleteAuthor(Long id) {
        Author existing = authorRepo.findById(id).orElse(null);
        if (existing != null) {
            authorRepo.deleteById(id);
        }
        return existing;
    }
}
