package com.example.CRUD.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.Entity.Employee;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {

	
}
