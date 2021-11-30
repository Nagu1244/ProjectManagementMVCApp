package com.pma.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pma.org.entities.Manager;
import com.pma.org.services.Impl.ManagerServiceImpl;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {
     
	@Autowired
	private ManagerServiceImpl managerService;
	@RequestMapping(method = RequestMethod.GET)
	public String createManagerForm(Model model)
	{
		Manager manager=new Manager();
		model.addAttribute("manager",manager);
		return "manager/manager-newform";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveManagerForm(@ModelAttribute("manager") Manager manager)
	{
		managerService.saveManagerDetails(manager);
		return "redirect:/manager";
	}
}
