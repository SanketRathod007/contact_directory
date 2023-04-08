package com.sanket.contactdirectory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.contactdirectory.entity.Email;
import com.sanket.contactdirectory.entity.Person;
import com.sanket.contactdirectory.repository.EmailRepository;

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
    public Email getEmailById(int id) {
        Optional<Email> optionalEmail = emailRepository.findById(id);
        if (optionalEmail.isPresent()) {
            return optionalEmail.get();
        } else {
            throw new RuntimeException("Email not found for id: " + id);
        }
    }

    @Override
    public Email addEmail(Email email) {
    	Email nullEmail = new Email();
    	nullEmail.setEmailAddress("Duplicate Email Address");
    	try {
    		return emailRepository.save(email);
    	}catch(Exception e) {
    		e.getMessage();
    		return nullEmail;
    	}
        
    }

    @Override
    public Email updateEmail(int id, Email email) {
    		Email existingemail = getEmailById(id);
            existingemail.setPerson(email.getPerson());
            existingemail.setEmailAddress(email.getEmailAddress());
            existingemail.setEmailType(email.getEmailType());
            existingemail.setPrimaryEmail(email.isPrimaryEmail());
            return emailRepository.save(existingemail);
    }

    @Override
    public String deleteEmail(int id) {
        Optional<Email> optionalemail = emailRepository.findById(id);
        if (optionalemail.isPresent()) {
            emailRepository.deleteById(id);
            return "email is deleted";
        } else {
            return "email doesn't exist";
        }
    }
    
   public List<Person> searchByEmailAddress(String emailAddress){
	    List<Person> personList = new ArrayList<>();
   	
	   	personList = emailRepository.findByEmailAddressContaining(emailAddress);
	   	
	   	if (!personList.isEmpty()) {
	   		return personList;
	       } else {
	           throw new IllegalArgumentException("Persons with given email doesn't exist");
	       }
	}
   
   public List<Person> searchByEmailType(String emailType){
	    List<Person> personList = new ArrayList<>();
  	
	   	personList = emailRepository.findByEmailAddressContaining(emailType);
	   	
	   	if (!personList.isEmpty()) {
	   		return personList;
	       } else {
	           throw new IllegalArgumentException("Persons with given email type doesn't exist");
	       }
		}
   
}
	

