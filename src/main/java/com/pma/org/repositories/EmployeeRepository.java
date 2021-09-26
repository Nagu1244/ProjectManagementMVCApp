package com.pma.org.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pma.org.dto.EmployeeProject;
import com.pma.org.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Need to remove if not works from here
	// This method used to return the firstName,lastName,projectcount of the each
	// employee
	@Query(nativeQuery = true, value = "\r\n"
			+ "select e.first_name as firstName,e.last_name as lastName,e.email as email,count(pe.employee_id) as projectCount from projectmanagementapp.employee_tb e\r\n"
			+ " left join projectmanagementapp.project_employee pe on pe.employee_id=e.employee_id group by e.first_name,e.last_name order by 3 desc ")
	List<EmployeeProject> employeeProjects();

}
