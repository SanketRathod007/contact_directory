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
import org.springframework.web.bind.annotation.RestController;

import com.sanket.contactdirectory.entity.Address;
import com.sanket.contactdirectory.entity.Person;
import com.sanket.contactdirectory.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    
    private AddressService addressService;
    
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    
    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }
    
    @GetMapping("address/{address}")
    public List<Person> searchByEmail(@PathVariable String address){
    	List<Person> personList = new ArrayList<>();
    	personList.add(new Person());
    	try {
    		return addressService.searchByAddress(address);
    	} catch (IllegalArgumentException e) {
    		return personList;
    	}	
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable int id) {
        try {
            Address address = addressService.getAddressById(id);
            return ResponseEntity.ok(address);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable int id, @RequestBody Address address) {
        try {
            Address updatedAddress = addressService.updateAddress(id, address);
            return ResponseEntity.ok(updatedAddress);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        String result = addressService.deleteAddress(id);
        if (result.equals("Address is deleted")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
