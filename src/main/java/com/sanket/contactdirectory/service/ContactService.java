package com.sanket.contactdirectory.service;

import java.util.List;

import com.sanket.contactdirectory.entity.Contact;

public interface ContactService {

    List<Contact> getAllContacts();

    Contact getContactById(long id);

    Contact addContact(Contact contact);

    Contact updateContact(long id, Contact contact);

    String deleteContact(long id);
}