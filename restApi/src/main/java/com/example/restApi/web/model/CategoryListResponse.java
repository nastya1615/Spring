package com.example.restApi.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryListResponse {

    private List<CategoryResponse> categories = new ArrayList<>();
}
