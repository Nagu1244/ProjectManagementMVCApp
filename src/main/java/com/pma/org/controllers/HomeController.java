package com.pma.org.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pma.org.dto.EmployeeProject;
import com.pma.org.dto.ProjectStageCount;
import com.pma.org.entities.Employee;
import com.pma.org.entities.Project;
import com.pma.org.repositories.EmployeeRepository;
import com.pma.org.repositories.ProjectRepository;
import com.pma.org.services.Impl.EmployeeServiceImpl;
import com.pma.org.services.Impl.ProjectServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {
     @Autowired
     private ProjectServiceImpl projectService;
     @Autowired
     private EmployeeServiceImpl empservice;
     @Autowired
     private EmployeeRepository emprepo;
     @Autowired
     private ProjectRepository projectrepo;
    @RequestMapping("") 
	public String getAllProjects(Model model)
	{
    	//get the ALl projects from database
		List<Project> listProjects=projectService.getListOfProjects();
		model.addAttribute("listProjects", listProjects);
		//get the all employess from database
		
		/*
		 * List<Employee> listEmployees=empservice.getListOfEmployees();
		 * model.addAttribute("employees", listEmployees);
		 */
		 
		 List<EmployeeProject> employeesProjectCnt=emprepo.employeeProjects();
		  model.addAttribute("employeesListProjectCnt", employeesProjectCnt);
		 
		  //get the label and value from Project repository
		  List<ProjectStageCount> projectStageCount=projectrepo.projectStageCount();
		  model.addAttribute("projectStageCount", projectStageCount);
    	
		return "main/home";
	}
    
	/*
	 * @RequestMapping(value="/allemp",method=RequestMethod.GET) public String
	 * listOfEmployees(Model model) { List<Employee>
	 * listEmployees=empservice.getListOfEmployees();
	 * model.addAttribute("employees", listEmployees); return "home"; }
	 */
}
