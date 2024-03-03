package com.example.restApi.repository;

import com.example.restApi.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseNewsRepository extends JpaRepository<News,Long> {
}
