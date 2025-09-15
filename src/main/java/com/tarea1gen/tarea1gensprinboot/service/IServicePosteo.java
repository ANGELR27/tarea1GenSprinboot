package com.tarea1gen.tarea1gensprinboot.service;

import com.tarea1gen.tarea1gensprinboot.model.Posteo;

import java.util.List;

/**
 * 
 */
public interface IServicePosteo {
    List<Posteo> findAllPosteo();
    Posteo findPosteoById(Long id);
    Posteo save(Posteo posteo);
    Posteo update(Long id, Posteo posteo);
    void delete(Long id);
}
