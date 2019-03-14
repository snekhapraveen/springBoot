package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
