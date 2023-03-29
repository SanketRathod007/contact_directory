package com.sanket.contactdirectory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
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

