package com.example.homework_2_7.event;

import com.example.homework_2_7.event.AddStudentEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AddStudentEventListner {

    @EventListener(AddStudentEvent.class)
    public void listenAddSrudent(AddStudentEvent event){
        System.out.println("Информация о добавленном пользователе\n"+event);
    }
}
