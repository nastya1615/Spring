package com.example.homework_2_7.StudentPart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Student {

    UUID id;
    String firstName;
    String lastName;
    int age;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
