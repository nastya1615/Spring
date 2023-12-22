package com.example.homework38.repository;

import com.example.homework38.entity.Contact;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactRepository {

    List<Contact> findAll();

    Optional<Contact> findByID(UUID uuid);

    Contact save(Contact contact);

    Contact update(Contact contact);

    void deleteContact(UUID uuid);

}
