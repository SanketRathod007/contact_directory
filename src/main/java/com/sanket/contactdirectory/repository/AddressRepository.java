package com.sanket.contactdirectory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sanket.contactdirectory.entity.Address;
import com.sanket.contactdirectory.entity.Person;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query("select a.persons from Address a where "
			+ "(a.streetAddress like %?1%) "
			+ "or (LOWER(a.city) like %?1%) "
			+ "or (LOWER(a.state) like %?1%) "
			+ "or (LOWER(a.zipCode) like %?1%)"
			+ "or (LOWER(a.country) like %?1%)"
			+ "or (LOWER(a.addressType) like %?1%)")
	  List<Person> findByAddressContaining(String address);
	
}
