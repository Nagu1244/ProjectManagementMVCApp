package com.pma.org.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="manager_tb")
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
	)
	private int managerId;
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	private String name;
	private String email;
	private String contactNumber;
	@OneToMany(mappedBy = "manager")
	private Set<Employee> listEmployee;
	public Manager(String name, String email, String contactNumber,Set<Employee> listEmployee) {
		super();
		this.name = name;
		this.email = email;
		this.contactNumber=contactNumber;
		this.listEmployee = listEmployee;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Manager()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Employee> getListEmployee() {
		return listEmployee;
	}
	public void setListEmployee(Set<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}
	

}
