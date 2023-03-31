package com.sanket.contactdirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.contactdirectory.dao.EmailRepository;
import com.sanket.contactdirectory.entity.Email;

@Service
public class EmailServiceImpl implements EmailService {

    private EmailRepository emailRepository;
	
	@Autowired
	public EmailServiceImpl(EmailRepository emailRepository) {
	    this.emailRepository = emailRepository;
	}
	    
    
    @Override
    public List<Email> getAllEmails() {
        return (List<Email>) emailRepository.findAll();
    }

    @Override
    public Email getEmailById(long id) {
        Optional<Email> optionalEmail = emailRepository.findById(id);
        if (optionalEmail.isPresent()) {
            return optionalEmail.get();
        } else {
            throw new RuntimeException("Email not found for id: " + id);
        }
    }

    @Override
    public Email addEmail(Email email) {
        return emailRepository.save(email);
    }

    @Override
    public Email updateEmail(long id, Email email) {
    		Email existingemail = getEmailById(id);
            existingemail.setPerson(email.getPerson());
            existingemail.setEmailAddress(email.getEmailAddress());
            existingemail.setEmailType(email.getEmailType());
            existingemail.setPrimaryEmail(email.isPrimaryEmail());
            return emailRepository.save(existingemail);
    }

    @Override
    public String deleteEmail(long id) {
        Optional<Email> optionalemail = emailRepository.findById(id);
        if (optionalemail.isPresent()) {
            emailRepository.deleteById(id);
            return "email is deleted";
        } else {
            return "email doesn't exist";
        }
    }
	
}
