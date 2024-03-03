package com.example.restApi.service.impl;

import com.example.restApi.entity.Client;
import com.example.restApi.entity.Comment;
import com.example.restApi.exception.EntityNotFoundException;
import com.example.restApi.repository.DatabaseCommentRepository;
import com.example.restApi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final DatabaseCommentRepository databaseCommentRepository;

    @Override
    public List<Comment> findAll() {
        return databaseCommentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return databaseCommentRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(MessageFormat
                .format("Комментарий с id {0} не найден!",id)));

    }

    @Override
    public Comment save(Comment comment) {
        return databaseCommentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        Comment newComment = new Comment();
        BeanUtils.copyProperties(comment,newComment);
        return databaseCommentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        databaseCommentRepository.deleteById(id);
    }
}
