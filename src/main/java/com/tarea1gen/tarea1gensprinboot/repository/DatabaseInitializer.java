package com.tarea1gen.tarea1gensprinboot.repository;

import com.tarea1gen.tarea1gensprinboot.model.Posteo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final IPosteo posteoRepo;

    public DatabaseInitializer(IPosteo posteoRepo) {
        this.posteoRepo = posteoRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (posteoRepo.count() == 0) {
            posteoRepo.save(new Posteo(null, "Primer post", "Angel"));
            posteoRepo.save(new Posteo(null, "Aprendiendo Spring", "Juan"));
            posteoRepo.save(new Posteo(null, "Persistencia con H2", "Maria"));
        }
    }
}
