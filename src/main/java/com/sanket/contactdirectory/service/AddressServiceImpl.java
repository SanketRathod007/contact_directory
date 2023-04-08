package com.sanket.contactdirectory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.contactdirectory.entity.Address;
import com.sanket.contactdirectory.entity.Person;
import com.sanket.contactdirectory.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	

    private AddressRepository addressRepository;
    
    @Autowired
    public AddressServiceImpl(AddressRepository AddressRepository) {
        this.addressRepository = AddressRepository;
    }
    
    @Override
    public List<Address> getAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            return optionalAddress.get();
        } else {
            throw new IllegalArgumentException("Address not found for id: " + id);
        }
    }

    @Override
    public Address addAddress(Address Address) {
        return addressRepository.save(Address);
    }

    @Override
    public Address updateAddress(int id, Address Address) {
    		Address existingAddress = getAddressById(id);
            existingAddress.setStreetAddress(Address.getStreetAddress());
            existingAddress.setCity(Address.getCity());
            existingAddress.setState(Address.getState());
            existingAddress.setZipCode(Address.getZipCode());
            existingAddress.setCountry(Address.getCountry());
            existingAddress.setAddressType(Address.getAddressType());
            existingAddress.setPerson(Address.getPerson());
            return addressRepository.save(existingAddress);
    }

    @Override
    public String deleteAddress(int id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            addressRepository.deleteById(id);
            return "Address is deleted";
        } else {
            return "Address doesn't exist";
        }
    }
    
    public List<Person> searchByAddress(String address){
    		List<Person> personList = new ArrayList<>();
      	
    		personList = addressRepository.findByAddressContaining(address);
	   		
    		if (!personList.isEmpty()) {
    			return personList;
    		} else {
	            throw new IllegalArgumentException("Persons with given address doesn't exist");
    		}
    }	

}
