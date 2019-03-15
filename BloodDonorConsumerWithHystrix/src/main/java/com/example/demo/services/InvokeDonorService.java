package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class InvokeDonorService {

	@Autowired
	public RestTemplate template;
	
	@Autowired
	LoadBalancerClient balancedClient;
	
	@HystrixCommand(fallbackMethod="myFallBack")
	public String invoke(String bloodGroup) {
		System.out.println("Inside Normal flow");
		ServiceInstance instance = balancedClient.choose("search-blooddonor-service");
		
		System.out.println(instance.getUri());
		String baseUrl = instance.getUri().toString();
		baseUrl = baseUrl + "/search/" + bloodGroup;
		String response = template.getForObject(baseUrl, String.class);
		return response;
	}
	
	public String myFallBack(String bloodGroup) {
		System.out.println("Fallback method called");
		return "Service is down! It will be up shortly...";
	}
}
