package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Book {

	private long bookNumber;
	private String bookName;
	private Author author;	
	
	public Book() {
		log.info("Book constructor called!");//This will not be printed when Bean using this is given Lazy = true and it is not initialized.		
		
	}
}
