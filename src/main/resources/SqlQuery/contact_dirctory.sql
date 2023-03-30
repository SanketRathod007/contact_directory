DROP DATABASE IF EXISTS contact_directory;

CREATE DATABASE contact_directory;

USE contact_directory;

CREATE TABLE person (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  gender VARCHAR(10),
  is_admin BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (id)
);

CREATE TABLE contacts (
  id INT NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  phone_type VARCHAR(20),
  is_primary_phone BOOLEAN,
  PRIMARY KEY (id),
  FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE emails (
  id INT NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  email_address VARCHAR(255) NOT NULL,
  email_type VARCHAR(20),
  is_primary_email BOOLEAN,
  PRIMARY KEY (id),
  FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE address (
  id INT NOT NULL AUTO_INCREMENT,
  street_address VARCHAR(255) NOT NULL,
  city VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  zip_code VARCHAR(20) NOT NULL,
  country VARCHAR(50) NOT NULL,
  address_type VARCHAR(20),
  PRIMARY KEY (id)
);

CREATE TABLE person_address (
  person_id INT NOT NULL,
  address_id INT NOT NULL,
  is_primary_address BOOLEAN,
  PRIMARY KEY (person_id, address_id),
  FOREIGN KEY (person_id) REFERENCES person(id),
  FOREIGN KEY (address_id) REFERENCES address(id)
);
