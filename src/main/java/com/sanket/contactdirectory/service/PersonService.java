package com.sanket.contactdirectory.service;

import java.util.List;

import com.sanket.contactdirectory.entity.Person;

public interface PersonService {

    List<Person> getAllPersons();
    
    Person getPersonById(int id);
    
    Person addPerson(Person person);
    
    Person updatePerson(int id, Person person);
    
    String deletePerson(int id);
    
    List<Person> searchByFirstName(String firstname);
    
    List<Person> searchByLastName(String lastname);
    
    List<Person> searchByGender(String gender);
}