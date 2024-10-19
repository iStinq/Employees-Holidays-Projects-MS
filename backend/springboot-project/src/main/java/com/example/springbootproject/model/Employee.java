package com.example.springbootproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name= "employees")
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	@Column(name="email_id")
	private String emailID;
	private String job;
	
	@ManyToOne
	private Projet projet;
	
	@OneToOne
	private Conge conge;
	
	public Employee() {
		
	}
	public Employee(long id, String firstName, String lastName, String emailID, Projet projet, Conge conge) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.projet = projet;
		this.conge = conge;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Conge getConge() {
		return conge;
	}
	public void setConge(Conge conge) {
		this.conge = conge;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID
				+ ", projet=" + projet + ", conge=" + conge + "]";
	}
	
	
	
}
	
