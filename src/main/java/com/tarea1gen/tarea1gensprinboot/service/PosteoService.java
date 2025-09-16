package com.tarea1gen.tarea1gensprinboot.service;

import com.tarea1gen.tarea1gensprinboot.model.Author;
import com.tarea1gen.tarea1gensprinboot.model.Posteo;
import com.tarea1gen.tarea1gensprinboot.repository.IAuthor;
import com.tarea1gen.tarea1gensprinboot.repository.IPosteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IServicePosteo {

    @Autowired
    private IPosteo posteoRepo;


    @Override
    public List<Posteo> findAllPosteo() {
        return posteoRepo.findAll();
    }

    @Override
    public Posteo findPosteoById(Long id) {
        return posteoRepo.findById(id).orElse(null);
    }

    @Override
    public Posteo save(Posteo posteo) {
        return posteoRepo.save(posteo);
    }

    @Override
    public Posteo update(Long id, Posteo posteo) {
        Optional<Posteo> existente = posteoRepo.findById(id);
        if (existente.isEmpty()) {
            return null;
        }
        Posteo toUpdate = existente.get();
        toUpdate.setTitulo(posteo.getTitulo());
        toUpdate.setAutor(posteo.getAutor());
        return posteoRepo.save(toUpdate);
    }

    @Override
    public void delete(Long id) {
        if (posteoRepo.existsById(id)) {
            posteoRepo.deleteById(id);
        }
    }
}
