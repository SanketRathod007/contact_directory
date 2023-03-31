package com.sanket.contactdirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.contactdirectory.dao.PersonRepository;
import com.sanket.contactdirectory.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

 
    private PersonRepository personRepository;
    
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person getPersonById(long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new IllegalArgumentException("Person not found for id: " + id);
        }
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(long id, Person person) {
    		Person existingPerson = getPersonById(id);
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setLastName(person.getLastName());
            existingPerson.setGender(person.getGender());
            existingPerson.setContacts(person.getContacts());
            existingPerson.setEmails(person.getEmails());
            existingPerson.setAddresses(person.getAddresses());
            return personRepository.save(existingPerson);
    }

    @Override
    public String deletePerson(long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            personRepository.deleteById(id);
            return "Person is deleted";
        } else {
            return "Person doesn't exist";
        }
    }
    
}
