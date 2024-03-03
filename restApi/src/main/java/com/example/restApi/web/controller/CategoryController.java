package com.example.restApi.web.controller;

import com.example.restApi.entity.Category;
import com.example.restApi.entity.Comment;
import com.example.restApi.mapper.CategoryMapper;
import com.example.restApi.service.CategoryService;
import com.example.restApi.web.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<CategoryListResponse> findAll(){
        return ResponseEntity.ok(categoryMapper.categoryListToResponse(categoryService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable long id){
        return ResponseEntity.ok(categoryMapper.categoryToResponse(categoryService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create (@RequestBody CategoryRequest request){
        Category category = categoryService.save(categoryMapper.requestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapper.categoryToResponse(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update (@PathVariable("id") long id,@RequestBody CategoryRequest request){
        Category updateCategory = this.categoryService.update(this.categoryMapper.requestToCategory(id,request));
        return ResponseEntity.ok(this.categoryMapper.categoryToResponse(updateCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
