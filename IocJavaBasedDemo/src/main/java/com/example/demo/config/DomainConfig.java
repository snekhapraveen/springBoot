package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Author;

@Configuration
public class DomainConfig {

	@Bean(name="secondAuthor")
	public Author author() {
		return new Author(102, "Rajesh");
	}
}
