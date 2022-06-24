package mypkg.entity;

import java.beans.Transient;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="Employee")
public class Employee {
	
	
	public static final String SEQUENCE_NAME="user_sequence";
	
	@Id
	private long id;
	private String firstname;
	private String lastname;
	private String emailid;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(long id, String firstname, String lastname, String emailid) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

}
