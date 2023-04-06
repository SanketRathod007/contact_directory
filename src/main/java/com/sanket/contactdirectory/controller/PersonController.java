package com.sanket.contactdirectory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.contactdirectory.entity.Person;
import com.sanket.contactdirectory.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    
    private PersonService personService;
    
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }
    
    @GetMapping("firstname/{firstname}")
    public List<Person> searchByFirstName(@PathVariable String firstname){
    	String firstName = firstname.toLowerCase();
    	List<Person> personList = new ArrayList<>();
    	personList.add(new Person());
    	try {
    		return personService.searchByFirstName(firstName);
    	} catch (IllegalArgumentException e) {
    		return personList;
    	}	
    }
    
    @GetMapping("lastname/{lastname}")
    public List<Person> searchByLastName(@PathVariable String lastname){
    	String lastName = lastname.toLowerCase();
    	List<Person> personList = new ArrayList<>();
    	personList.add(new Person());
    	try {
    		return personService.searchByLastName(lastName);
    	} catch (IllegalArgumentException e) {
    		return personList;
    	}	
    }
    
    @GetMapping("gender/{gender}")
    public List<Person> searchByGender(@PathVariable String gender){
    	String geNder = gender.toLowerCase();
    	List<Person> personList = new ArrayList<>();
    	personList.add(new Person());
    	try {
    		return personService.searchByGender(geNder);
    	} catch (IllegalArgumentException e) {
    		return personList;
    	}	
    }
    
    
    
    @GetMapping("id/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        try {
            Person person = personService.getPersonById(id);
            return ResponseEntity.ok(person);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Person addPerson(@RequestBody Person person) {
    	try {
        return personService.addPerson(person);}
    	catch(Exception e) {
    		return null;
    	}
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        try {
            Person updatedPerson = personService.updatePerson(id, person);
            return ResponseEntity.ok(updatedPerson);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        String result = personService.deletePerson(id);
        if (result.equals("Person is deleted")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}