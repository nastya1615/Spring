package com.example.restApi.mapper;

import com.example.restApi.entity.Comment;
import com.example.restApi.entity.News;
import com.example.restApi.service.ClientService;
import com.example.restApi.service.NewsService;
import com.example.restApi.web.model.CommentRequest;
import com.example.restApi.web.model.NewsRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommentMapperDelegate implements CommentMapper {

    @Autowired
    private ClientService clientService;

    @Autowired
    private NewsService newsService;

    @Override
    public Comment requestToComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setText(commentRequest.getText());
        comment.setNews(newsService.findById(commentRequest.getNewsId()));
        comment.setClient(clientService.findById(commentRequest.getClientId()));
        return comment;
    }


    @Override
    public Comment requestToComment(Long commentId, CommentRequest request) {
        Comment comment = this.requestToComment(request);
        comment.setId(commentId);
        return comment;
    }

}
