package com.sanket.contactdirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.contactdirectory.dao.ContactRepository;
import com.sanket.contactdirectory.entity.Contact;

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
        return contactRepository.save(contact);
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

//	@Override
//	public Contact updateContact(int id, Contact contact) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}