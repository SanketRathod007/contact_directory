package com.sanket.contactdirectory.service;

import java.util.List;

import com.sanket.contactdirectory.entity.Address;

public interface AddressService {
	
    List<Address> getAllAddresses();
    
    Address getAddressById(long id);
    
    Address addAddress(Address address);
    
    Address updateAddress(long id, Address address);
    
    String deleteAddress(long id);
    

}
