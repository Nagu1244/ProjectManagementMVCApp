package com.pma.org.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.pma.org.dto.EmployeeProject;
import com.pma.org.entities.Employee;

public interface EmployeeService {

	void saveEmployeeDetails(Employee employee);
	List<Employee> getListOfEmployees();
	//Here List<Long> employees submitted from the Project form
	List<Employee> getAllEmployeesById(List<Long> employees);
	
	
	
}
