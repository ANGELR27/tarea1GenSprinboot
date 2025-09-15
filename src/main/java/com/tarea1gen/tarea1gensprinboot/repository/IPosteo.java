package com.tarea1gen.tarea1gensprinboot.repository;

import com.tarea1gen.tarea1gensprinboot.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPosteo extends JpaRepository<Posteo, Long> {
   
}
