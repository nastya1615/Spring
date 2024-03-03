package com.example.restApi.repository;

import com.example.restApi.entity.Client;
import com.example.restApi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseCommentRepository extends JpaRepository<Comment,Long> {
}
