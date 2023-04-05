package com.sanket.contactdirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.contactdirectory.dao.AddressRepository;
import com.sanket.contactdirectory.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {
	

    private AddressRepository AddressRepository;
    
    @Autowired
    public AddressServiceImpl(AddressRepository AddressRepository) {
        this.AddressRepository = AddressRepository;
    }
    
    @Override
    public List<Address> getAllAddresses() {
        return (List<Address>) AddressRepository.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        Optional<Address> optionalAddress = AddressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            return optionalAddress.get();
        } else {
            throw new IllegalArgumentException("Address not found for id: " + id);
        }
    }

    @Override
    public Address addAddress(Address Address) {
        return AddressRepository.save(Address);
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
            existingAddress.setPersons(Address.getPersons());
            return AddressRepository.save(existingAddress);
    }

    @Override
    public String deleteAddress(int id) {
        Optional<Address> optionalAddress = AddressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            AddressRepository.deleteById(id);
            return "Address is deleted";
        } else {
            return "Address doesn't exist";
        }
    }

}
