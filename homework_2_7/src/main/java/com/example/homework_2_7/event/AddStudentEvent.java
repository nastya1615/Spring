package com.example.homework_2_7.event;

import com.example.homework_2_7.StudentPart.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AddStudentEvent extends ApplicationEvent {
    private final Student student;


    public AddStudentEvent(Object source,Student student) {
        super(source);
        this.student = student;

    }

    @Override
    public String toString() {
        return student.toString() ;
    }
}
