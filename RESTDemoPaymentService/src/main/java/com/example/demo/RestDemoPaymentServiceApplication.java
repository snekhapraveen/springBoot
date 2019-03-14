package com.example.demo;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Payment;
import com.example.demo.repo.PaymentRepo;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSwagger2
@EnableDiscoveryClient
public class RestDemoPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoPaymentServiceApplication.class, args);
	}

	@Bean(name="ramesh")
	public Payment payment() {
		return new Payment(202, LocalDate.of(2018, Month.FEBRUARY, 10), 4500, "Ramesh"); 
	}
	
	@Bean(name="suresh")
	public Payment secondPayment() {
		return new Payment(203, LocalDate.of(2018, Month.MARCH, 12), 5500, "Suresh"); 
	}
	
	//@Bean//comment when rerunning the program to avoid adding duplicate entries
	public CommandLineRunner commandLineRunner(PaymentRepo repo) {//Injecting PaymentRepo to CommandLineRunner bean
		return args->{
			repo.save(new Payment(204, LocalDate.of(2018, Month.MARCH, 12), 5500, "Suresh"));
			repo.save(new Payment(205, LocalDate.of(2018, Month.FEBRUARY, 14), 3500, "Mahesh"));
			repo.save(new Payment(206, LocalDate.of(2018, Month.APRIL, 10), 13500, "Rakesh"));
			repo.save(new Payment(207, LocalDate.of(2018, Month.JUNE, 24), 21500, "Mithran"));
			repo.save(new Payment(208, LocalDate.of(2018, Month.AUGUST, 6), 30500, "Rajesh"));
			repo.save(new Payment(209, LocalDate.of(2018, Month.JANUARY, 14), 13500, "Kannan"));
		};
	}
	
	//Swagger
	@Bean 
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).
				select().apis(RequestHandlerSelectors.any()).build();//All APIs are selected here
	}
}
//HAL Browser : http://localhost:4041/browser/index.html#/
//Swagger UI: http://localhost:4041/swagger-ui.html#