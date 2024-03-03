package com.example.restApi.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentRequest {

    private String text;
    private Long newsId;
    private Long clientId;
}
