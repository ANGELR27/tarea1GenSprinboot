package com.tarea1gen.tarea1gensprinboot.controller;

import com.tarea1gen.tarea1gensprinboot.model.Posteo;
import com.tarea1gen.tarea1gensprinboot.service.PosteoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/posteos")
public class PosteoController {

    private final PosteoService posteoService;

    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public ResponseEntity<List<Posteo>> getAllPosteos() {
        List<Posteo> posteos = posteoService.findAllPosteo();
        return ResponseEntity.ok(posteos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posteo> getPosteoById(@PathVariable Long id) {
        Posteo posteo = posteoService.findPosteoById(id);

        if (posteo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(posteo);
    }

    @PostMapping
    public ResponseEntity<Posteo> createPosteo(@RequestBody Posteo posteo) {
        if (posteo.getTitulo() == null || posteo.getTitulo().isBlank()
                || posteo.getAutor() == null || posteo.getAutor().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Posteo creado = posteoService.save(posteo);
        return ResponseEntity
                .created(URI.create("/posteos/" + creado.getId()))
                .body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posteo> updatePosteo(@PathVariable Long id, @RequestBody Posteo posteo) {
        if (posteo.getTitulo() == null || posteo.getTitulo().isBlank()
                || posteo.getAutor() == null || posteo.getAutor().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Posteo actualizado = posteoService.update(id, posteo);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosteo(@PathVariable Long id) {
        Posteo existente = posteoService.findPosteoById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        posteoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}