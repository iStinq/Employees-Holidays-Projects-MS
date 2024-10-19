package com.example.springbootproject.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootproject.model.Conge;
import com.example.springbootproject.model.Employee;
import com.example.springbootproject.model.Projet;
import com.example.springbootproject.repository.CongeRepository;
import com.example.springbootproject.repository.EmployeeRepository;
import com.example.springbootproject.repository.ProjetRepository;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/v1/")
public class CongeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjetRepository projetRepository;
	
	@Autowired
	private CongeRepository congeRepository;
	
	@PostMapping("/validationconge")
	public boolean requestConge(@RequestBody Employee employee,@RequestParam(name="dateDebut") LocalDate datedebut,@RequestParam(name="dateFin") LocalDate datefin) {
        List<Projet> projets = projetRepository.findByEmployeeAndDates(employee, datedebut, datefin);
        
        if (!projets.isEmpty()) {
            return false;
        }
        Conge conge = new Conge();
        conge.setEmployee(employee);
        conge.setDatedebut(datedebut);
        conge.setDatefin(datefin);
        congeRepository.save(conge);
        
		Employee e = employeeRepository.findById(employee.getId()).orElse(null);
        
		e.setConge(conge);
		
		employeeRepository.save(e);
        
        return true;
    }
	

}
