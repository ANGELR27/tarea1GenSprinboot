package com.tarea1gen.tarea1gensprinboot.controller;

import com.tarea1gen.tarea1gensprinboot.model.Author;
import com.tarea1gen.tarea1gensprinboot.model.Posteo;
import com.tarea1gen.tarea1gensprinboot.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        return ResponseEntity.ok(authorService.findAllAuthor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id) {
        Author a = authorService.findAuthorById(id);
        if (a == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(a);
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author author) {
        if (author.getName() == null || author.getName().isBlank() || author.getEmail() == null || author.getEmail().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Author created = authorService.save(author);
        return ResponseEntity.created(URI.create("/authors/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        Author updated = authorService.updateAuthor(author);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Author deleted = authorService.deleteAuthor(id);
        if (deleted == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Posteo>> getPostsByAuthor(@PathVariable Long id) {
        Author a = authorService.findAuthorById(id);
        if (a == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(a.getPosteos());
    }
}
