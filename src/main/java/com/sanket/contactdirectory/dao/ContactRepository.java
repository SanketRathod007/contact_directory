package com.sanket.contactdirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.contactdirectory.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
