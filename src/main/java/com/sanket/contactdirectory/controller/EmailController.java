package com.sanket.contactdirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.contactdirectory.entity.Email;
import com.sanket.contactdirectory.service.EmailService;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    
    private EmailService emailService;
    
    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @GetMapping
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable int id) {
        try {
            Email email = emailService.getEmailById(id);
            return ResponseEntity.ok(email);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Email addEmail(@RequestBody Email email) {
        return emailService.addEmail(email);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Email> updateEmail(@PathVariable int id, @RequestBody Email email) {
        try {
            Email updatedEmail = emailService.updateEmail(id, email);
            return ResponseEntity.ok(updatedEmail);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmail(@PathVariable int id) {
        String result = emailService.deleteEmail(id);
        if (result.equals("Email is deleted")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}