package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.PartnerDriver;
import com.example.demo.repos.DriverRepository;

@Controller
public class PartnerDriverController {

	@Autowired
	private PartnerDriver cabDriver;//Command object
	
	@Autowired
	private ModelAndView mdlView;
	
	@Autowired
	private DriverRepository repo;
	
	@GetMapping("/")
	public String init() {
		return "index";
	}
	
	@GetMapping("/addDriver")
	public ModelAndView sendForm() {
		mdlView.addObject("command",cabDriver);//binding
		mdlView.setViewName("addCabDriver");
		return mdlView;
	}
	
	@PostMapping("/addDriver")
	public String onSubmit(@ModelAttribute("passedBean") PartnerDriver driver) {//@ModelAttribute is for inducing DI
		PartnerDriver response = repo.save(driver);
		if(response != null) {
			return "success";
		} else {
			return "error";
		}		
	}
}
