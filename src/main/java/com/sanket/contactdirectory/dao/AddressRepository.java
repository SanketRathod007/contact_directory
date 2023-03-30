package com.sanket.contactdirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.contactdirectory.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
