package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.utils.ClientView;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="springpayment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long txnId;
	private LocalDate txnDate;
	@JsonView(ClientView.class)
	private double amount;
	@JsonView(ClientView.class)
	private String customerName;
}
