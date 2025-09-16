package com.tarea1gen.tarea1gensprinboot.controller;

import com.tarea1gen.tarea1gensprinboot.model.Comment;
import com.tarea1gen.tarea1gensprinboot.model.Posteo;
import com.tarea1gen.tarea1gensprinboot.service.CommentService;
import com.tarea1gen.tarea1gensprinboot.service.PosteoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class CommentController {

    private final CommentService commentService;
    private final PosteoService posteoService;

    public CommentController(CommentService commentService, PosteoService posteoService) {
        this.commentService = commentService;
        this.posteoService = posteoService;
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getById(@PathVariable Long id) {
        Comment c = commentService.findById(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getByPost(@PathVariable Long postId) {
        Posteo p = posteoService.findPosteoById(postId);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(commentService.findByPost(postId));
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Comment> createForPost(@PathVariable Long postId, @RequestBody Comment comment) {
        Posteo p = posteoService.findPosteoById(postId);
        if (p == null || comment.getText() == null || comment.getText().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        comment.setPost(p);
        Comment created = commentService.save(comment);
        return ResponseEntity.created(URI.create("/comments/" + created.getId())).body(created);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> update(@PathVariable Long id, @RequestBody Comment comment) {
        Comment updated = commentService.update(id, comment);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Comment existing = commentService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
