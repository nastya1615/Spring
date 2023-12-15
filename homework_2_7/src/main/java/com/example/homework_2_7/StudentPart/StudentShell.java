package com.example.homework_2_7.StudentPart;

import com.example.homework_2_7.event.AddStudentEvent;
import com.example.homework_2_7.event.DeleteStudentEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ShellComponent()
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentShell {
    private  ApplicationEventPublisher publisher;


    private final Map<UUID, Student> studentMap = new HashMap<>();

    @ShellMethod(key = "addStudent")
    public void addStudent(String firstName, String lastName, int age){
        UUID uuid = UUID.randomUUID();
        Student student = new Student(uuid,firstName,lastName,age);
        studentMap.put(uuid,student);
        AddStudentEvent addStudentEvent = new AddStudentEvent(this,student);
        publisher.publishEvent(addStudentEvent);

    }

    @ShellMethod(key = "writeAllStudent")
    public void writeAllStudent(){
        studentMap.forEach((integer, student) -> System.out.println(student.toString()) );
    }

    @ShellMethod(key = "deleteStudent")
    public void deleteStudent(UUID uuid){
        studentMap.remove(uuid);
        DeleteStudentEvent deleteStudentEvent = new DeleteStudentEvent(this,uuid);
        publisher.publishEvent(deleteStudentEvent);
    }

    @ShellMethod(key = "clearStudentList")
    public void clearStudentList(){
        studentMap.clear();
    }


}
