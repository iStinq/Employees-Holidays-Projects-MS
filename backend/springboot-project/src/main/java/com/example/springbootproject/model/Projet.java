package com.example.springbootproject.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Projet {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private LocalDate datedebut;
	private LocalDate datefin;
	@OneToMany(mappedBy = "projet")
	private List<Employee> employees;
	
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public void setDatedebut(LocalDate datedebut) {
		this.datedebut = datedebut;
	}
	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}
	public Projet() {
		
	}
	public Projet(Long id, String name, LocalDate datedebut, LocalDate datefin) {
		super();
		this.id = id;
		this.name = name;
		this.datedebut = datedebut;
		this.datefin = datefin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDatedebut() {
		return datedebut;
	}
	
	public LocalDate getDatefin() {
		return datefin;
	}
	public void setDatefinprojet(LocalDate datefin) {
		this.datefin = datefin;
	}
	@Override
	public String toString() {
		return "Projet [id=" + id + ", name=" + name + ", datedebutprojet=" + datedebut + ", datefinprojet="
				+ datefin + "]";
	}
	

}
