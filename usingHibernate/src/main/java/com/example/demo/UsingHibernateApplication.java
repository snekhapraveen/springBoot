package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Book;
import com.example.demo.service.BookServiceImpl;

@SpringBootApplication
public class UsingHibernateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(UsingHibernateApplication.class, args);
		BookServiceImpl dao = ctx.getBean(BookServiceImpl.class);
		Long pkey = dao.addBook(ctx.getBean(Book.class));
		
		System.out.println("One book added with details" + pkey);
		dao.getBooks().forEach(System.out::println);
	}

	@Bean
	public Book book() {
		return new Book(102,"Head first Java",450);
	}
}
