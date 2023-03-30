package com.sanket.contactdirectory.service;

import java.util.List;

import com.sanket.contactdirectory.entity.Person;

public interface PersonService {

    List<Person> getAllPersons();
    
    Person getPersonById(long id);
    
    Person addPerson(Person person);
    
    Person updatePerson(long id, Person person);
    
    String deletePerson(long id);
    
}