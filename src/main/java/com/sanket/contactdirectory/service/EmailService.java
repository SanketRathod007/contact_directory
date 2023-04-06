package com.sanket.contactdirectory.service;

import java.util.List;

import com.sanket.contactdirectory.entity.Email;
import com.sanket.contactdirectory.entity.Person;

public interface EmailService {

	List<Email> getAllEmails();
    
    Email getEmailById(int id);
    
    Email addEmail(Email email);
    
    Email updateEmail(int id, Email email);
    
    String deleteEmail(int id);
    
    List<Person> searchByEmailAddress(String emailAddress);
    
    List<Person> searchByEmailType(String emailType);
	
}
