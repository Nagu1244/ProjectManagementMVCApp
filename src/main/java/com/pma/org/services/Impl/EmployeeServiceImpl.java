package com.pma.org.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pma.org.dto.EmployeeProject;
import com.pma.org.entities.Employee;
import com.pma.org.repositories.EmployeeRepository;
import com.pma.org.services.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
	private EmployeeRepository emprepo;
	@Override
	public void saveEmployeeDetails(Employee employee) {
		
		emprepo.save(employee);		
	}
	@Override
	public List<Employee> getListOfEmployees() {
		
		return emprepo.findAll();
	}
	//this method returns the All employee details from Db
	public List<Employee> getAllEmployeesById(List<Long> employees) {
		
		return emprepo.findAllById(employees);
	}
	
	

}
