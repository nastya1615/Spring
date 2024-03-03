package com.example.restApi.repository;

import com.example.restApi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseCategoryRepository extends JpaRepository<Category,Long> {
}
