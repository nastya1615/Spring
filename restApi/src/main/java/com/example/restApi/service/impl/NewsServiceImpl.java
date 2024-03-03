package com.example.restApi.service.impl;

import com.example.restApi.aop.RedactNews;
import com.example.restApi.entity.News;
import com.example.restApi.exception.EntityNotFoundException;
import com.example.restApi.repository.DatabaseNewsRepository;
import com.example.restApi.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final DatabaseNewsRepository databaseNewsRepository;
    @Override
    public List<News> findAll() {
        return databaseNewsRepository.findAll();
    }

    @Override
    public News findById(Long id) {
        return databaseNewsRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException(MessageFormat.format("Новости с id {0} не найдено", id)));
    }

    @Override
    public News save(News news) {
        return databaseNewsRepository.save(news);
    }

    @Override
    public News update(News news) {
        News exictedNews = findById(news.getId());
        BeanUtils.copyProperties(news, exictedNews);
        return databaseNewsRepository.save(news);
    }

    @Override
    public void deleteById(Long id) {
        databaseNewsRepository.deleteById(id);
    }
}
