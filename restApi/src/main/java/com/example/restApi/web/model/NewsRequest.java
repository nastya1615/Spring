package com.example.restApi.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsRequest {
    private Long clientId;
    private Long categoryId;
    private String text;
}
