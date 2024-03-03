package com.example.restApi.web.controller;


import com.example.restApi.aop.RedactNews;
import com.example.restApi.entity.Category;
import com.example.restApi.entity.News;
import com.example.restApi.mapper.NewsMapper;
import com.example.restApi.service.NewsService;
import com.example.restApi.web.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;
    private final NewsMapper newsMapper;

    @GetMapping
    public ResponseEntity<NewsListResponse> findAll(){
        return ResponseEntity.ok(newsMapper.newsListToResponseList(newsService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponse> findById(@PathVariable long id){
        return ResponseEntity.ok(newsMapper.newsToResponse(newsService.findById(id)));
    }


    @PostMapping
    public ResponseEntity<NewsResponse> create (@RequestBody NewsRequest request){
        News newNews = newsService.save(newsMapper.requestToNews(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(newsMapper.newsToResponse(newNews));
    }

    @PutMapping("/{id}/{clientId}")
    @RedactNews
    public ResponseEntity<NewsResponse> update (@PathVariable("id") long id,@PathVariable("clientId") Long clientId,@RequestBody NewsRequest request){
        News updateNews= this.newsService.update(this.newsMapper.requestToNews(id,request));
        return ResponseEntity.ok(this.newsMapper.newsToResponse(updateNews));
    }

    @DeleteMapping("/{id}/{clientId}")
    @RedactNews
    public ResponseEntity<Void> delete(@PathVariable("id") Long id,@PathVariable("clientId") Long clientId){
        this.newsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
