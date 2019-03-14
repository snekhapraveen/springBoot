package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.PartnerDriver;
import com.example.demo.model.Payment;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class IocDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(IocDemoApplication.class, args);
		//F3 to attach src. Download src for Spring from net
		
		Payment payment = ctx.getBean(Payment.class);
		
		//payment.getdriver(); //gives default values
		PartnerDriver driver = payment.getdriver();
		
		driver.setDriverId(12345);
		driver.setDriverName("Suresh");
		driver.setMobileNumber(98989898);
		driver.setRating(4.5);
		

		//System.out.println(payment);//toString() will be called
		log.info(payment.toString());		
	}

}
