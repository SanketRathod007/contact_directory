package com.sanket.contactdirectory.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanket.contactdirectory.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
