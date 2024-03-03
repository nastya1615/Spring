package com.example.restApi.mapper;

import com.example.restApi.entity.News;
import com.example.restApi.service.CategoryService;
import com.example.restApi.service.ClientService;
import com.example.restApi.web.model.NewsRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class NewsMapperDelegate implements NewsMapper{

    @Autowired
    private ClientService clientService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public News requestToNews(NewsRequest request){
        News news = new News();
        news.setText(request.getText());
        news.setClient(clientService.findById(request.getClientId()));
        news.setCategory(categoryService.findById(request.getCategoryId()));
        return news;
    }

    @Override
    public News requestToNews(Long newsId, NewsRequest request ){
        News news =this.requestToNews(request);
        news.setId(newsId);
        return news;
    }


}
