package com.sanket.contactdirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.contactdirectory.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {

}
