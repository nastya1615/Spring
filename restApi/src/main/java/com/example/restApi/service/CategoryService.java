package com.example.restApi.service;

import com.example.restApi.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);

    Category save( Category category);

    Category update (Category category);

    void deleteById(Long id);
}
