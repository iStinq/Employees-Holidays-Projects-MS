package com.example.springbootproject.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
@Entity
public class Conge {
	@Id
	@GeneratedValue
	private Long id;
	private LocalDate datedebut;
	private LocalDate datefin;
	@OneToOne(mappedBy = "conge")
	private Employee employee;
	public Conge() {
		
	}
	public Conge(Long id, LocalDate datedebut, LocalDate datefin) {
		super();
		this.id = id;
		this.datedebut = datedebut;
		this.datefin = datefin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(LocalDate datedebut) {
		this.datedebut = datedebut;
	}
	public LocalDate getDatefin() {
		return datefin;
	}
	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Conge [id=" + id + ", datedebutconge=" + datedebut + ", datefinconge=" + datefin + "]";
	}
	

}
