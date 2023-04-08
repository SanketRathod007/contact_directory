package com.sanket.contactdirectory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.contactdirectory.entity.Contact;
import com.sanket.contactdirectory.entity.Person;
import com.sanket.contactdirectory.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public Contact getContactById(int id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            return optionalContact.get();
        } else {
            throw new RuntimeException("Contact not found for id: " + id);
        }
    }

    @Override
    public Contact addContact(Contact contact) {
    	Contact nullContact = new Contact();
    	nullContact.setPhoneNumber("Duplicate phone number");
    	try {
    		return contactRepository.save(contact);
    	}catch(Exception e) {
    		e.getMessage();
    		return nullContact;
    	}
        
    }

    @Override
    public Contact updateContact(int id, Contact contact) {
        Contact existingContact = getContactById(id);
        existingContact.setPerson(contact.getPerson());
        existingContact.setPhoneNumber(contact.getPhoneNumber());
        existingContact.setPhoneType(contact.getPhoneType());
        existingContact.setPrimaryPhone(contact.isPrimaryPhone());
        return contactRepository.save(existingContact);
    }

    @Override
    public String deleteContact(int id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            contactRepository.deleteById(id);
            return "Contact deleted";
        } else {
            return "Contact not found";
        }
    }
    
    public List<Person> searchByphoneNumber(String phoneNumber){
    	List<Person> personList = new ArrayList<>();
      	
	   	personList = contactRepository.findByphoneNumberContaining(phoneNumber);
	   	
	   	if (!personList.isEmpty()) {
	   		return personList;
	       } else {
	           throw new IllegalArgumentException("Persons with given phonenumber doesn't exist");
	       }
		}
    
}

