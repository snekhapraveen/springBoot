package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="driverPayment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id //To mention paymentId as primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//To automatically generate the values. Here it increments by 1 automatically.
	private long paymentId;
	@Column(name="Amount")
	private double amount;
	private String details;
	private LocalDate paymentDate;
}
