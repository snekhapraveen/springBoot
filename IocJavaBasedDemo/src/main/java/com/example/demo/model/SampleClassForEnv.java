package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.Getter;
import lombok.Setter;

public class SampleClassForEnv {

	@Getter
	@Setter
	private long SampleId;
	//Lifecycle
	@Autowired
	private Environment env;
	public SampleClassForEnv() {
		super();
		//System.out.println(env.getDefaultProfiles().toString());//Throws exception
	}
	
	public void init() {
		System.out.println(env.getDefaultProfiles().toString());
	}
}
