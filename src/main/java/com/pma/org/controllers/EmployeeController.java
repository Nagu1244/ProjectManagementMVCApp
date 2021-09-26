package com.pma.org.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pma.org.entities.Employee;
import com.pma.org.repositories.EmployeeRepository;
import com.pma.org.services.Impl.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
	@Autowired
	private EmployeeServiceImpl empservice;
	@Autowired
	private EmployeeRepository emprepo;
	
	@RequestMapping(value="/new") 
	public String createProject(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "employer/new-employee";
	}
	//changed from Model to Model Attribute
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String processEmployeeFormData(@ModelAttribute("employee") Employee employee)
	{
		empservice.saveEmployeeDetails(employee);
		return "redirect:/employees";
	}
	@RequestMapping("")
	public String getAllEmployees(Model model)
	{
		List<Employee> listemp=empservice.getListOfEmployees();
		model.addAttribute("listOfEmployees", listemp);
		return "employer/list-employees";
	}
	//Pass the existing records to update view
	@RequestMapping(value="/update",method = RequestMethod.GET)
	public String getExitsEmployee(@RequestParam("id") Long employeeId, Model model)
	{
		Employee exisEmployee=emprepo.findById(employeeId).get();
		model.addAttribute("employee", exisEmployee);
		return "employer/update";
	}
	//update Employee records
	@RequestMapping(value="/edit/{id}",method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") Long employeeId)
	{
		Employee existEmp=emprepo.findById(employeeId).get();
		existEmp.setFirstName(employee.getFirstName());
		existEmp.setLastName(employee.getLastName());
		existEmp.setEmail(employee.getEmail());
		emprepo.save(existEmp);
		return "redirect:/employees";
	}
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Long employeeId)
	{
		emprepo.deleteById(employeeId);
		return "redirect:/employees";
	}
}
