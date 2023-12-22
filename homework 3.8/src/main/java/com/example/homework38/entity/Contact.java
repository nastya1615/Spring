package com.example.homework38.entity;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import java.util.UUID;

@Data
@FieldNameConstants
public class Contact {

    private UUID uuid;

    private String firstName;

    private String lastName;

    private String email;

    private String telephoneNumber;

}
