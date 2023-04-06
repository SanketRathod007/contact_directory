package com.sanket.contactdirectory.service;

import java.util.List;

import com.sanket.contactdirectory.entity.Address;
import com.sanket.contactdirectory.entity.Person;

public interface AddressService {
	
    List<Address> getAllAddresses();
    
    Address getAddressById(int id);
    
    Address addAddress(Address address);
    
    Address updateAddress(int id, Address address);
    
    String deleteAddress(int id);
    
    List<Person> searchByAddress(String address);
    

}
