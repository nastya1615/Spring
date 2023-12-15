package com.example.homework_2_7.event;

import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class DeleteStudentEvent extends ApplicationEvent {
    private final UUID uuid;
    public DeleteStudentEvent(Object source,UUID uuid) {
        super(source);
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "uuid=" + uuid;
    }
}
