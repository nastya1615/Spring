package com.example.restApi.mapper;

import com.example.restApi.entity.Comment;
import com.example.restApi.web.model.CommentListResponse;
import com.example.restApi.web.model.CommentRequest;
import com.example.restApi.web.model.CommentResponse;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@DecoratedWith(CommentMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    Comment requestToComment (CommentRequest commentRequest);

    @Mapping(source = "commentId", target = "id")
    Comment requestToComment (Long commentId,CommentRequest commentRequest);

    CommentResponse commentToResponse (Comment comment);

    default CommentListResponse commentListToResponseList(List<Comment> comments){
        CommentListResponse response = new CommentListResponse();
        response.setComment(comments.stream().map(this::commentToResponse).collect(Collectors.toList()));
        return response;
    }


}
