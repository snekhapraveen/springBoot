package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.netflix.discovery.EurekaClient;

@RestController
public class PaymentClient {

	@Autowired
	RestTemplate template;
	
//	@Autowired
//	private EurekaClient client;
	
	//Using direct URL
//	@GetMapping("/showOnePayment")
//	public String getPayment() {
//		return template.getForObject("http://localhost:4041/showPayment", String.class);
//	}
	
	//Using Eureka
//	@GetMapping("/showOnePayment")
//	public String getPayment() {
//		return template.getForObject("http://payment-details-service/showPayment", String.class);		
//	}
	
	//Using Consul
	@GetMapping("/showOnePayment")
	public String getPayment() {
		return template.getForObject("http://payment-service/showPayment", String.class);		
	}
}
