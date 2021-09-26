package com.pma.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pma.org.entities.UserAccounts;
import com.pma.org.repositories.UserAccountsRepository;

@Controller

public class AccountController {
  
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Autowired
	UserAccountsRepository accountRepo;
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String createAccount(Model model)
	{
		UserAccounts userAccount=new UserAccounts();
		model.addAttribute("userAccount", userAccount);
		return "security/register";
	}
	 
	@RequestMapping(value="/register/save",method=RequestMethod.POST)
	public String saveUser(Model model,UserAccounts user)
	{
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		accountRepo.save(user);
		return "redirect:/home";
	}
}
