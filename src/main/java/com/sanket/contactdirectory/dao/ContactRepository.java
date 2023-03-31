package com.sanket.contactdirectory.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanket.contactdirectory.entity.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
