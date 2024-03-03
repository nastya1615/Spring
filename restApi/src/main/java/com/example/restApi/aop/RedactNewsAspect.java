package com.example.restApi.aop;

import com.example.restApi.entity.News;
import com.example.restApi.service.NewsService;
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
public class RedactNewsAspect {

    private final NewsService newsService;

    @Around("@annotation(RedactNews)")
    @SneakyThrows
    public Object checkClient(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        News news = newsService.findById((Long) args[0]);
        Long clientId = news.getClient().getId();
        if(clientId != (long)args[1]){
            log.info("У данного клиента нет прав на удаление и редактирование новости!");
            return null;
        }
        else{
            return proceedingJoinPoint.proceed();
        }

    }


}
