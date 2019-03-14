package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.model.SampleClassForEnv;

@Configuration
public class ApplicationConfig {

	@Autowired
	Author secondAuthor;
	
	//@Autowired
	//DomainConfig config;
	
	@Bean
	public Author author() {
		return new Author(101,"Ramesh");
	}
	
	@Bean
	public Book book() {
		//return new Book(1090, "Spring in action", author());//Since class bean is called here, author() in this file will only be called.
		
		//If second author needs to be called from here??! Put secondAuthor bean in seperate config and Autowire either the config or the Bean alone from that config.
		//return new Book(1090, "Spring in action", config.author());// Used if Config is autowired
		return new Book(1090, "Spring in action", secondAuthor);// Used if secondAuthor bean alone is autowired
	}
	
	//Autowiring Collections
	@Bean
	public Book springBook() {
		return new Book(203, "Spring",author());
	}
	
	@Bean
	public Book javaBook() {
		return new Book(204, "Java 10",author());
	}
	
	@Bean
	public Book dotNetBook() {
		return new Book(205, "Mastering dotNet",author());
	}
	
	@Bean
	public Library library() {
		Library gandhiLibrary = new Library();
		gandhiLibrary.setLibraryName("Gandhi Library");
		return gandhiLibrary;
	}
	
	@Bean(initMethod="init")
	public SampleClassForEnv sample() {
		return new SampleClassForEnv();
	}
}
