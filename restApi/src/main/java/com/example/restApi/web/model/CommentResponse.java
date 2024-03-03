package com.example.restApi.web.model;

import com.example.restApi.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentResponse {
    private Long id;
    private String text;
}
