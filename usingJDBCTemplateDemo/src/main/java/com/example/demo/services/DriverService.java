package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PartnerDriver;

@Repository
public class DriverService {

	@Autowired //Since already defined in main class
	private JdbcTemplate template;
	@Autowired
	private PartnerDriver driver;
	
	public int addDriver() {
		String sql = "insert into partnerDriver values(?,?,?,?)";
		int rowAdded = template.update(sql, driver.getDriverId(), driver.getDriverName(), driver.getMobileNumber(), driver.getRating());
		return rowAdded;
	}
}
