package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.repo.PaymentRepo;
import com.example.demo.utils.ClientView;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class PaymentController {

	@Autowired
	@Qualifier("ramesh")
	private Payment object1;
	
	@Autowired
	@Qualifier("suresh")
	private Payment object2;
	
	@Autowired
	private List<Payment> list;
	
	//to get the data from DB table
	@Autowired
	private PaymentRepo repo;
	
	@GetMapping("/showPayment")
	public Payment getPayment() {
		return object1;
	}
	
	@GetMapping("/showAll")
	public List<Payment> showAll() {
		return list;
	}
	
	//to get the data from DB table
	@GetMapping("/findAll")
	@JsonView(ClientView.class)//Setting the view. So this API alone will display only those exposed to CLientView
	public List<Payment> findAll() {
		return repo.findAll();//JpaRepository is extended in PaymentRepo to avoid iterable here
	}
	
	//to save the data to DB table
	@GetMapping("/addPayment")
	@ApiOperation(value="This method adds a new payment entry")
	public Payment addPayment(@ApiParam("Takes payment details") @RequestBody Payment pmt) {
		return repo.save(pmt);
	}
		
	@GetMapping("/findById/{id}")
	public Payment getPaymentById(@PathVariable long id) {
		if(id==object1.getTxnId()) {
			return object1;
		}else if(id==object2.getTxnId()){
			return object2;
		}else {
			return null;
		}
	}
}
