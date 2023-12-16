package com.example.homework_2_7.config;

import com.example.homework_2_7.studentPart.StudentShell;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class EventConfiguration {

    @Bean
    public StudentShell studentShell(ApplicationEventPublisher publisher){
        return new StudentShell(publisher);

    }


}
