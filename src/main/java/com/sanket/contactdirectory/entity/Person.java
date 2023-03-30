package com.sanket.contactdirectory.entity;

import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Email> emails;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
        name = "person_address",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses;

	

    // constructors 
    public Person() {}
    
    public Person(String firstName, String lastName, String gender, boolean isAdmin, List<Contact> contacts,
			List<Email> emails, List<Address> addresses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.isAdmin = isAdmin;
		this.contacts = contacts;
		this.emails = emails;
		this.addresses = addresses;
	}
    
    
    //getters and setters 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	
    
    //other methods
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", isAdmin=" + isAdmin + ", contacts="
				+ contacts + ", emails=" + emails + ", addresses=" + addresses + "]";
	}
	
}