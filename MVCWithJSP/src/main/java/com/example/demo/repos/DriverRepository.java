package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PartnerDriver;

@Repository
public interface DriverRepository extends CrudRepository<PartnerDriver, Long> {

	
}
