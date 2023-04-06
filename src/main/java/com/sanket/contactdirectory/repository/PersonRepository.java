package com.sanket.contactdirectory.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sanket.contactdirectory.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("select p from Person p where LOWER(p.firstName) like %?1%")
	  List<Person> findByFirstnameContaining(String firstname);
	
	@Query("select p from Person p where LOWER(p.lastName) like %?1%")
	  List<Person> findByLastnameContaining(String lastname);
	
	@Query("select p from Person p where LOWER(p.gender) = ?1")
	  List<Person> findByGender(String gender);
}
