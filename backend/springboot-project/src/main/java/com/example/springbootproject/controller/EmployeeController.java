package com.example.springbootproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootproject.model.Employee;
import com.example.springbootproject.model.EmployeeDTO;
import com.example.springbootproject.repository.EmployeeRepository;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employees
	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployees(){
		List<Employee> employees = employeeRepository.findAll();
	    return employees.stream()
	            .map(employee -> new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailID(), employee.getJob()))
	            .collect(Collectors.toList());
		
	}
	
	//create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);		
	}
	
	@GetMapping("/employees/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		EmployeeDTO emp = new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailID(), employee.getJob());
		return emp;
		
	}
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElse(null);
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailID(employeeDetails.getEmailID());
		employee.setJob(employeeDetails.getJob());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee ;
	}
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).orElse(null);
		
		employeeRepository.delete(employee);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
