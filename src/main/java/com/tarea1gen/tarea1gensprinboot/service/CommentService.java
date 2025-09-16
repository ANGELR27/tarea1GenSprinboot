package com.tarea1gen.tarea1gensprinboot.service;

import com.tarea1gen.tarea1gensprinboot.model.Comment;
import com.tarea1gen.tarea1gensprinboot.model.Posteo;
import com.tarea1gen.tarea1gensprinboot.repository.IComment;
import com.tarea1gen.tarea1gensprinboot.repository.IPosteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private IComment commentRepo;

    @Autowired
    private IPosteo posteoRepo;

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findByPost(Long postId) {
        return commentRepo.findByPost_Id(postId);
    }

    @Override
    public Comment save(Comment comment) {
        if (comment.getPost() != null && comment.getPost().getId() != null) {
            Posteo p = posteoRepo.findById(comment.getPost().getId()).orElse(null);
            comment.setPost(p);
        }
        return commentRepo.save(comment);
    }

    @Override
    public Comment update(Long id, Comment comment) {
        Comment existing = commentRepo.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setText(comment.getText());
        if (comment.getPost() != null && comment.getPost().getId() != null) {
            Posteo p = posteoRepo.findById(comment.getPost().getId()).orElse(null);
            existing.setPost(p);
        }
        if (comment.getCreatedAt() != null) {
            existing.setCreatedAt(comment.getCreatedAt());
        }
        return commentRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (commentRepo.existsById(id)) {
            commentRepo.deleteById(id);
        }
    }
}
