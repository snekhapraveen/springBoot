package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
@Entity
@Table(name="mvcPartnerDriverTable")
public class PartnerDriver {

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="driverId")
	private long driverId;
	private String driverName;
	private long mobileNumber;
	public double rating;
	public PartnerDriver() {
		super();
		log.info("Partner Driver Initialized");
	}	
}