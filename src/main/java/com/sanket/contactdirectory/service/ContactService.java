package com.sanket.contactdirectory.service;

import java.util.List;

import com.sanket.contactdirectory.entity.Contact;
import com.sanket.contactdirectory.entity.Person;

public interface ContactService {

    List<Contact> getAllContacts();

    Contact getContactById(int id);

    Contact addContact(Contact contact);

    Contact updateContact(int id, Contact contact);

    String deleteContact(int id);
    
    List<Person> searchByphoneNumber(String phoneNumber);
}