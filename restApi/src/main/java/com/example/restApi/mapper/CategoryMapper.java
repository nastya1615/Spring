package com.example.restApi.mapper;

import com.example.restApi.entity.Category;
import com.example.restApi.web.model.CategoryListResponse;
import com.example.restApi.web.model.CategoryRequest;
import com.example.restApi.web.model.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = {NewsMapperDelegate.class})
public interface CategoryMapper {

    Category requestToCategory(CategoryRequest request);

    @Mapping(source = "categoryId", target = "id")
    Category requestToCategory (Long categoryId, CategoryRequest request);

    CategoryResponse categoryToResponse(Category category);

    default CategoryListResponse categoryListToResponse(List<Category> categories){
        CategoryListResponse response = new CategoryListResponse();
        response.setCategories(categories.stream().map(this::categoryToResponse).collect(Collectors.toList()));
        return response;

    }
}
