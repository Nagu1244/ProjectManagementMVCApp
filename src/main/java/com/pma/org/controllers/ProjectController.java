package com.pma.org.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pma.org.dto.TimeChartDate;
import com.pma.org.entities.Employee;
import com.pma.org.entities.Project;
import com.pma.org.repositories.EmployeeRepository;
import com.pma.org.repositories.ProjectRepository;
import com.pma.org.services.Impl.EmployeeServiceImpl;
import com.pma.org.services.Impl.ProjectServiceImpl;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    
	@Autowired
	private ProjectRepository prorepo;
	@Autowired
	private EmployeeRepository emprepo;
	@Autowired
	private ProjectServiceImpl service;
	@Autowired
	private EmployeeServiceImpl empservice;
	@RequestMapping("/new")
	public String createProjectForm(Model model)
	{
		model.addAttribute("project", new Project());
		//Passing listof Employees data to Model to get the employee details on Project Form page
		List<Employee> employees=empservice.getListOfEmployees();
		model.addAttribute("allEmployees", employees);
		
		return "/projects/new-projects";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveProject(Model model,Project project)
	{
		
         service.saveProject(project);
		//get the employess by from DB findAllById() method
		/*
		 * List<Employee> listemp=empservice.getAllEmployeesById(employees); //listemp
		 * has project ids(foreign keys). we have to set these values to Employee table
		 * for(Employee emp:listemp) { emp.setProject(project); emprepo.save(emp);
		 * 
		 * }
		 */
		return "redirect:/projects";
	}
	@RequestMapping("")
	public String getAllProjects(Model model)
	{
		List<Project> listProjects=service.getListOfProjects();
		model.addAttribute("projects", listProjects);
		return "/projects/list-projects";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateProjectDetails(@RequestParam("id") Long projectId,Model model)
	{
		Project projectDetailsObj=service.findByProjectId(projectId);
		model.addAttribute("project", projectDetailsObj);
		List<Employee> employees=empservice.getListOfEmployees();
		model.addAttribute("allEmployees", employees);
		return "projects/update-project";
	}
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editProjectDetails(@RequestParam("id") Long projectId, @ModelAttribute("project") Project project)
	{
		Project existingProject=service.findByProjectId(projectId);
		existingProject.setName(project.getName());
		existingProject.setStage(project.getStage());
		existingProject.setEmployees(project.getEmployees());
		existingProject.setDescription(project.getDescription());
		existingProject.setStartDate(project.getStartDate());
		existingProject.setEndDate(project.getEndDate());
		service.saveProject(existingProject);
		return "redirect:/projects";
	}
	
	@RequestMapping(value="/delete")
	public String deleteProject(@RequestParam("id") Long projectId)
	{
		service.deleteProjectById(projectId);
		return "redirect:/projects";
	}
	
	//TimeChart data 
	@RequestMapping(value="/timelines")
	public String getTimeChartData(Model model) throws JsonProcessingException
	{
		List<TimeChartDate> timeChartData=service.getTimeChartData();
		//convert into into Josn String format
		ObjectMapper mapperObject=new ObjectMapper();
		String jsonStringData=mapperObject.writeValueAsString(timeChartData);
		model.addAttribute("projectTimeList", jsonStringData);
		return "projects/timeline-chart";
	}
	
	//**********************Restful Webservices********************//
	@ResponseBody
	@RequestMapping(value="/projectApicall",method=RequestMethod.GET)
	public List<Project> projectAPICall()
	{
		List<Project> listProjects=prorepo.findAll();
		return listProjects;
	}
}
