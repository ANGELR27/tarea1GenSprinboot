package com.tarea1gen.tarea1gensprinboot.service;

import com.tarea1gen.tarea1gensprinboot.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findById(Long id);
    List<Comment> findByPost(Long postId);
    Comment save(Comment comment);
    Comment update(Long id, Comment comment);
    void delete(Long id);
}
