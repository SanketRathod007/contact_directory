package com.sanket.contactdirectory.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sanket.contactdirectory.entity.Contact;
import com.sanket.contactdirectory.entity.Person;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	@Query("select c.person from Contact c where c.phoneNumber like %?1%")
	  List<Person> findByphoneNumberContaining(String phoneNumber);
	
}
