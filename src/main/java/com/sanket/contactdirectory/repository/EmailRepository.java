package com.sanket.contactdirectory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sanket.contactdirectory.entity.Email;
import com.sanket.contactdirectory.entity.Person;

public interface EmailRepository extends JpaRepository<Email, Integer> {

	@Query("select e.person from Email e where e.emailAddress like %?1%")
	  List<Person> findByEmailAddressContaining(String emailAddress);
	
	@Query("select e.person from Email e where LOWER(e.emailType) like %?1%")
	  List<Person> findByEmailTypeContaining(String emailType);
	
}
