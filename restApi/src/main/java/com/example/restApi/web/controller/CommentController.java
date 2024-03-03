package com.example.restApi.web.controller;

import com.example.restApi.aop.RedactComment;
import com.example.restApi.entity.Client;
import com.example.restApi.entity.Comment;
import com.example.restApi.mapper.CommentMapper;
import com.example.restApi.service.CommentService;
import com.example.restApi.web.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @GetMapping
    public ResponseEntity<CommentListResponse> findAll(){
        return ResponseEntity.ok(commentMapper.commentListToResponseList(commentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> findById(@PathVariable long id){
        return ResponseEntity.ok(commentMapper.commentToResponse(commentService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> create (@RequestBody CommentRequest request){
        Comment newComment = commentService.save(commentMapper.requestToComment(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(commentMapper.commentToResponse(newComment));
    }

    @PutMapping("/{id}/{clientId}")
    @RedactComment
    public ResponseEntity<CommentResponse> update (@PathVariable("id") long id,@PathVariable("clientId") long clientId,@RequestBody CommentRequest request){
        Comment updateComment = this.commentService.update(this.commentMapper.requestToComment(id,request));
        return ResponseEntity.ok(this.commentMapper.commentToResponse(updateComment));
    }

    @DeleteMapping("/{id}/{clientId}")
    @RedactComment
    public ResponseEntity<Void> delete(@PathVariable("id") Long id,@PathVariable("clientId") long clientId){
        this.commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
