package com.example.restApi.service;

import com.example.restApi.entity.Client;
import com.example.restApi.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment findById(Long id);

    Comment save(Comment comment);

    Comment update(Comment comment);

    void deleteById(Long id);
}
