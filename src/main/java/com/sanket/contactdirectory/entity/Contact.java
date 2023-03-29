package com.sanket.contactdirectory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "phone_type")
    private String phoneType;

    @Column(name = "is_primary_phone")
    private boolean isPrimaryPhone;

	
    // constructors
    public Contact() {}
    
    public Contact(Person person, String phoneNumber, String phoneType, boolean isPrimaryPhone) {
		super();
		this.person = person;
		this.phoneNumber = phoneNumber;
		this.phoneType = phoneType;
		this.isPrimaryPhone = isPrimaryPhone;
	}
    
    //getters and setters 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public boolean isPrimaryPhone() {
		return isPrimaryPhone;
	}

	public void setPrimaryPhone(boolean isPrimaryPhone) {
		this.isPrimaryPhone = isPrimaryPhone;
	}

	

    //other methods
	@Override
	public String toString() {
		return "Contact [id=" + id + ", person=" + person + ", phoneNumber=" + phoneNumber + ", phoneType=" + phoneType
				+ ", isPrimaryPhone=" + isPrimaryPhone + "]";
	}
}
