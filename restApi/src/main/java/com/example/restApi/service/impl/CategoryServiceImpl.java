package com.example.restApi.service.impl;

import com.example.restApi.entity.Category;
import com.example.restApi.exception.EntityNotFoundException;
import com.example.restApi.repository.DatabaseCategoryRepository;
import com.example.restApi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final DatabaseCategoryRepository databaseCategoryRepository;

    @Override
    public List<Category> findAll() {
        return databaseCategoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return databaseCategoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(
                MessageFormat.format("Категории с Id {0} не найдено!",id)));
    }

    @Override
    public Category save(Category category) {
        return databaseCategoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category exictedCategory = findById(category.getId());
        BeanUtils.copyProperties(category,exictedCategory);
        return databaseCategoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        databaseCategoryRepository.deleteById(id);
    }
}
