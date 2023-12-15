package com.example.homework_2_7.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DeleteStudentEventListner {

    @EventListener
    public void listenDeleteSrudent(DeleteStudentEvent event){

        System.out.println("Id удалённого пользователя " + event);
    }
}
