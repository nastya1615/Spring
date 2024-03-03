package com.example.restApi.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse {

    private Long id;
    private String nameCategory;
    private List<NewsResponse> news = new ArrayList<>();
}
