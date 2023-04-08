package com.sanket.contactdirectory.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "emails")
@JsonIdentityInfo(
		  scope = Email.class,
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonBackReference
    private Person person;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "email_type")
    private String emailType;

    @Column(name = "is_primary_email")
    private boolean isPrimaryEmail;

	
    // constructors 
    public Email() {}
    
    public Email(Person person, String emailAddress, String emailType, boolean isPrimaryEmail) {
		super();
		this.person = person;
		this.emailAddress = emailAddress;
		this.emailType = emailType;
		this.isPrimaryEmail = isPrimaryEmail;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public boolean isPrimaryEmail() {
		return isPrimaryEmail;
	}

	public void setPrimaryEmail(boolean isPrimaryEmail) {
		this.isPrimaryEmail = isPrimaryEmail;
	}

	

    //other methods
	@Override
	public String toString() {
		return "Email [id=" + id + ", person=" + person + ", emailAddress=" + emailAddress + ", emailType=" + emailType
				+ ", isPrimaryEmail=" + isPrimaryEmail + "]";
	}
}

