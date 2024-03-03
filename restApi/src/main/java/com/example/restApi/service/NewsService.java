package com.example.restApi.service;


import com.example.restApi.entity.News;

import java.util.List;

public interface NewsService {

    List<News> findAll();

    News findById(Long id);

    News save(News news);

    News update(News news);

    void deleteById(Long id);
}
