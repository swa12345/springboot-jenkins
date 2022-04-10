package com.example.CRUD.contoller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUD.Entity.Employee;
import com.example.CRUD.services.EmployeeServices;


@RestController
@RequestMapping("/Emp")
public class EmployeeController {
	
	Logger logger=LogManager.getLogger(EmployeeController.class);
	
	
	@Autowired
	private EmployeeServices empServices;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmpl(@RequestBody Employee emp){
		
		logger.info("Resource Created1");
		
		Employee employeeSaved=empServices.saveEmployee(emp);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getEmpl() {
		
		logger.info("Resource Information");
		
		List<Employee> listOfAllEmps=empServices.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listOfAllEmps,HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empId}")
	public ResponseEntity<Employee> getById(@PathVariable("empId") Long empId){
		Employee empById=empServices.getEmpById(empId);
		return new ResponseEntity<Employee>(empById,HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateById(@RequestBody Employee emp){
		
		logger.info("Resource has been updated");
		
		Employee updateEmp=empServices.updateEmpById(emp);
		logger.info(emp);
		return new ResponseEntity<Employee>(updateEmp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/del/{empId}")
	public ResponseEntity<Void> delById(@PathVariable("empId") Long empId){
		
		
		empServices.delEmpByid(empId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		
		
		
		
	}

	
	
	
	
	
	
}
