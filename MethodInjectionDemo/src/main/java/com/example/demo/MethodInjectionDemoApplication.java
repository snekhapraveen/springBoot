package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class MethodInjectionDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MethodInjectionDemoApplication.class, args);
		TrainingProvider prov1 = ctx.getBean(TrainingProvider.class);
		prov1.getFreshCourse();
		TrainingProvider prov2 = ctx.getBean(TrainingProvider.class);
		prov2.getFreshCourse();
		TrainingProvider prov3 = ctx.getBean(TrainingProvider.class);
		prov3.getFreshCourse();
	}
	
	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)	
	public Course course() {
		return new Course();
	}
//	@Bean
//	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
//	public TrainingProvider provider() {
//		return new TrainingProvider(course());
//	}
	//Without method injection, Course also becomes Singleton
	//For Method injection
	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public TrainingProvider provider() {
		return new TrainingProvider() {
			
			@Override
			public Course getFreshCourse() {
				System.out.println("Lookup Method called!!!");
				return new Course();
			}
		};
	}
}
