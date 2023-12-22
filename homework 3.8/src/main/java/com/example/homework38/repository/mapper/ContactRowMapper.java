package com.example.homework38.repository.mapper;

import com.example.homework38.entity.Contact;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setUuid(rs.getObject(Contact.Fields.uuid,java.util.UUID.class));
        contact.setEmail(rs.getString(Contact.Fields.email));
        contact.setFirstName(rs.getString(Contact.Fields.firstName));
        contact.setLastName(rs.getString(Contact.Fields.lastName));
        contact.setTelephoneNumber(rs.getString(Contact.Fields.telephoneNumber));
        return contact;
    }
}
