package com.example.restApi.mapper;

import com.example.restApi.entity.News;
import com.example.restApi.web.model.NewsListResponse;
import com.example.restApi.web.model.NewsRequest;
import com.example.restApi.web.model.NewsResponse;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;


@DecoratedWith(NewsMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = {CommentMapperDelegate.class})
public interface NewsMapper {

    News requestToNews(NewsRequest request);

    @Mapping(source = "newsId", target = "id")
    News requestToNews(Long newsId, NewsRequest request);

    NewsResponse newsToResponse(News news);

    default NewsListResponse newsListToResponseList(List<News> news){

        NewsListResponse response = new NewsListResponse();
        response.setNews(news.stream().map(this::newsToResponse).collect(Collectors.toList()));
        return response;
    }

}
