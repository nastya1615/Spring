package com.example.homework38.repository;

import com.example.homework38.entity.Contact;
import com.example.homework38.repository.mapper.ContactRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Primary
@RequiredArgsConstructor
@Slf4j
public class DatabaseContactRepository implements ContactRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Contact> findAll() {
        log.debug("Calling findAll in DatabaseContactRepository");
        String sql = "SELECT * FROM contact";
        return jdbcTemplate.query(sql,new ContactRowMapper());
    }

    @Override
    public Optional<Contact> findByID(UUID uuid) {
        log.debug("Calling findByID in DatabaseContactRepository");
        String sql = "SELECT * FROM contact where uuid = ?";
        Contact contact = DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        sql,
                        new ArgumentPreparedStatementSetter(new Object[] {uuid}),
                new RowMapperResultSetExtractor<>(new ContactRowMapper(),1)
                ));
        return Optional.ofNullable(contact);
    }

    @Override
    public Contact save(Contact contact) {
        log.debug("Calling save in DatabaseContactRepository");
        contact.setUuid(UUID.randomUUID());
        String sql = "INSERT INTO contact (uuid, firstName, lastName, email, telephoneNumber) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, contact.getUuid(),contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getTelephoneNumber());
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        log.debug("Calling update in DatabaseContactRepository");
        Contact existedContact = findByID(contact.getUuid()).orElse(null);
        if(existedContact != null){
            String sql = "UPDATE contact SET firstName = ?, lastName = ?,  email = ?, telephoneNumber=? WHERE uuid = ?";
            jdbcTemplate.update(sql,contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getTelephoneNumber(),contact.getUuid());
            return existedContact;
        }
        return null;
    }

    @Override
    public void deleteContact(UUID uuid) {
        log.debug("Calling deleteContact in DatabaseContactRepository");
        String sql = "DELETE FROM contact where uuid = ?";
        jdbcTemplate.update(sql,uuid);

    }


}
