package com.example.restApi.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsResponse {

    private Long id;
    private String text;
    private List<CommentResponse> comments = new ArrayList<>();

}
