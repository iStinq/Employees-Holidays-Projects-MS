package com.example.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootproject.model.Conge;


@Repository
public interface CongeRepository extends JpaRepository<Conge,Long>{

}
