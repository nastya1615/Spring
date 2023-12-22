package com.example.homework38.service;

import com.example.homework38.entity.Contact;
import com.example.homework38.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;
    @Override
    public List<Contact> findAll() {
        log.debug("Call findAll in TaskServiceImpl");
        return contactRepository.findAll();
    }

    @Override
    public Contact findByID(UUID uuid) {
        log.debug("Call findByID in TaskServiceImpl");
        return contactRepository.findByID(uuid).orElse(null);
    }

    @Override
    public Contact save(Contact contact) {
        log.debug("Call save in TaskServiceImpl");
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        log.debug("Call update in TaskServiceImpl");
        return contactRepository.update(contact);
    }

    @Override
    public void deleteContact(UUID uuid) {
        log.debug("Call deleteContact in TaskServiceImpl");
        contactRepository.deleteContact(uuid);

    }
}
