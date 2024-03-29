package com.example.restApi.web.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    private long id;
    private String name;
    private List<NewsResponse> news = new ArrayList<>();
}
