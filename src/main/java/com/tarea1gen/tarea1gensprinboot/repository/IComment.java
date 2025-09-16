package com.tarea1gen.tarea1gensprinboot.repository;

import com.tarea1gen.tarea1gensprinboot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IComment extends JpaRepository<Comment, Long> {
    java.util.List<Comment> findByPost_Id(Long postId);
}
