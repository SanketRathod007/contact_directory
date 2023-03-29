package com.sanket.contactdirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.contactdirectory.dao.PersonRepository;
import com.sanket.contactdirectory.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    
    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(int id) {
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
    public Person updatePerson(int id, Person person) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setLastName(person.getLastName());
            existingPerson.setGender(person.getGender());
            existingPerson.setContacts(person.getContacts());
            existingPerson.setEmails(person.getEmails());
            existingPerson.setAddresses(person.getAddresses());
            return personRepository.save(existingPerson);
        } else {
            throw new IllegalArgumentException("Person not found for id: " + id);
        }
    }

    @Override
    public String deletePerson(int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            personRepository.deleteById(id);
            return "Person is deleted";
        } else {
            return "Person doesn't exist";
        }
    }
    
}
