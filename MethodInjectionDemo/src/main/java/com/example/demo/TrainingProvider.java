package com.example.demo;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class TrainingProvider {

	private Course course;
	public TrainingProvider(Course course) {
		super();
		this.course = course;
		System.out.println("Training provider called....SINGLETON");
	}
	public TrainingProvider() {
		super();
		System.out.println("Training provider called....SINGLETON");
	}
	
	//For Method injection
	@Lookup
	public abstract Course getFreshCourse();
}
