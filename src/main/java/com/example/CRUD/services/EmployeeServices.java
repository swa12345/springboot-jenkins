package com.example.CRUD.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CRUD.Entity.Employee;



@Service
public interface EmployeeServices {

	public Employee saveEmployee(Employee e);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmpById(Long empId);
	
	public Employee updateEmpById(Employee e);
	
	public void delEmpByid(Long empId);
	
}
