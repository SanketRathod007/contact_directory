package com.sanket.contactdirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.contactdirectory.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}