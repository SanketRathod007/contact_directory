package com.sanket.contactdirectory.service;

import java.util.List;

import com.sanket.contactdirectory.entity.Contact;

public interface ContactService {

    List<Contact> getAllContacts();

    Contact getContactById(Long id);

    Contact addContact(Contact contact);

    Contact updateContact(Long id, Contact contact);

    String deleteContact(Long id);
}