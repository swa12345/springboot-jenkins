package com.example.CRUD.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CRUD.Entity.Employee;
import com.example.CRUD.Repo.EmployeeCrudRepo;


@Service
public class EmployeeInterfaceImpl implements EmployeeServices {
	
	@Autowired
	private EmployeeCrudRepo empRepo;

	@Override
	public Employee saveEmployee(Employee e) {
		Employee savedEmployee=empRepo.save(e);
		return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
		
	}

	@Override
	public Employee getEmpById(Long empId) {
		Employee empsaved=empRepo.findById(empId).get();
		return empsaved;
	}

	@Override
	public Employee updateEmpById(Employee empId) {
		Employee updateEmp=empRepo.save(empId);
		return updateEmp;
	
	
	}

	public void delEmpByid(Long empId) {
		empRepo.deleteById(empId);
	}

	
	

}
