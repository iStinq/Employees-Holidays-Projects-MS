package com.example.springbootproject.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springbootproject.model.Employee;
import com.example.springbootproject.model.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long>{
	@Query("SELECT p FROM Projet p WHERE :employee MEMBER OF p.employees AND p.datedebut <= :datefin AND p.datefin >= :datedebut")
	public List<Projet> findByEmployeeAndDates(@Param("employee")Employee employee, LocalDate datedebut, LocalDate datefin);

}
