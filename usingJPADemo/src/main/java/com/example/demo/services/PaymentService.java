package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Payment;
import com.example.demo.repos.PaymentRepository;

@Repository
public class PaymentService {

	@Autowired
	PaymentRepository repo;
	
	public Payment addPayment(Payment payment) {
		return repo.save(payment);
	}
	
	public Iterable<Payment> getAllPayments(){
		return repo.findAll();
	}
}
