package com.sanket.contactdirectory.service;

import java.util.List;

import com.sanket.contactdirectory.entity.Email;

public interface EmailService {

	List<Email> getAllEmails();
    
    Email getEmailById(long id);
    
    Email addEmail(Email email);
    
    Email updateEmail(long id, Email email);
    
    String deleteEmail(long id);
	
}
