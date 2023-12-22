package com.example.homework38.service;

import com.example.homework38.entity.Contact;
import java.util.List;
import java.util.UUID;

public interface ContactService {
    List<Contact> findAll();

    Contact findByID(UUID uuid);

    Contact save(Contact contact);

    Contact update(Contact contact);

    void deleteContact(UUID uuid);
}
