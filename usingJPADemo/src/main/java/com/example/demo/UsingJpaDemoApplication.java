package com.example.demo;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Payment;
import com.example.demo.services.PaymentService;

@SpringBootApplication
public class UsingJpaDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(UsingJpaDemoApplication.class, args);
		PaymentService service = ctx.getBean(PaymentService.class);
		Payment payment = ctx.getBean(Payment.class);
		service.addPayment(payment);
	}

	@Bean
	public Payment payment() {
		return new Payment(102, 4500, "driverBata", LocalDate.of(2018, Month.MARCH, 2));
	}
}
