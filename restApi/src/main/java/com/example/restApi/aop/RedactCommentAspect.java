package com.example.restApi.aop;

import com.example.restApi.entity.Comment;
import com.example.restApi.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class RedactCommentAspect {

        private final CommentService commentService;

        @Around("@annotation(RedactComment)")
        @SneakyThrows
        public Object checkClient(ProceedingJoinPoint proceedingJoinPoint){
            Object[] args = proceedingJoinPoint.getArgs();
            Comment comment = commentService.findById((Long) args[0]);
            Long clientId = comment.getClient().getId();
            if(clientId != (long)args[1]){
                log.info("У данного клиента нет прав на удаление и редактирование этого комментария!");
                return null;
            }
            else{
                return proceedingJoinPoint.proceed();
            }

        }
    }
