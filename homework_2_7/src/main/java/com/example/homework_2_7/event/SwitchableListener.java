package com.example.homework_2_7.event;

import com.example.homework_2_7.studentPart.StudentShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("app.switchable-listener.enable")
public class SwitchableListener {
    @Autowired
    StudentShell studentShell = new StudentShell();

    @EventListener(ApplicationStartedEvent.class)
    public void startProgram(){
        studentShell.addStudent("Иван","Иванов",27);
        studentShell.addStudent("Петров","Петр",29);
        studentShell.addStudent("Николай","Чернов",30);


    }
}
