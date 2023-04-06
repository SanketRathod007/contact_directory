package com.sanket.contactdirectory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.contactdirectory.entity.Person;
import com.sanket.contactdirectory.repository.PersonRepository;

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
    public String deletePerson(int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            personRepository.deleteById(id);
            return "Person is deleted";
        } else {
            return "Person doesn't exist";
        }
    }
    
    @Override
    public List<Person> searchByFirstName(String firstname){
    	List<Person> personList = new ArrayList<>();
    	
    	personList = personRepository.findByFirstnameContaining(firstname);
    	
    	if (!personList.isEmpty()) {
    		return personList;
        } else {
            throw new IllegalArgumentException("Persons doesn't exist containing given firstname");
        }
    	
    }

	@Override
	public List<Person> searchByLastName(String lastname) {
		List<Person> personList = new ArrayList<>();
    	
    	personList = personRepository.findByLastnameContaining(lastname);
    	
    	if (!personList.isEmpty()) {
    		return personList;
        } else {
            throw new IllegalArgumentException("Persons doesn't exist containing given lastname");
        }
	}

	@Override
	public List<Person> searchByGender(String gender) {
		List<Person> personList = new ArrayList<>();
    	
    	personList = personRepository.findByGender(gender);
    	
    	if (!personList.isEmpty()) {
    		return personList;
        } else {
            throw new IllegalArgumentException("Persons with given gender doesn't exist");
        }
	}
    
}
