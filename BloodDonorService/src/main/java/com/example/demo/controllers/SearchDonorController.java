package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchDonorController {

	@GetMapping("/search/{bloodGroup}")
	public String getDonorByGroup(@PathVariable String bloodGroup) {
		String donorName = "Ramesh";
		if(bloodGroup.equals("bpos")) {
			donorName = "Suresh";
		}
		return donorName;
	}
	
}
