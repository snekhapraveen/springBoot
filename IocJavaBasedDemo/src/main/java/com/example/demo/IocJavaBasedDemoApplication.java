package com.example.demo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.model.SampleClassForEnv;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class IocJavaBasedDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(IocJavaBasedDemoApplication.class, args);
		
//		Author ram = (Author)ctx.getBean("author");
//		Author raj = (Author)ctx.getBean("secondAuthor");
//		log.info(ram.toString());
//		log.info(raj.toString());
//		
//		Book bk = ctx.getBean(Book.class);
//		log.info(bk.toString());
		
		//Autowiring Collections
		Library library = ctx.getBean(Library.class);
		library.getBookList().forEach(System.out::println);
		//to get book names alone
		library.getBookList().
		    stream().map((book)->book.getBookName()).forEach(System.out::println);
		//or
//		List<String> list = library.getBookList().
//				stream().map((book)->book.getBookName()).collect(Collection.toList());
//		list.forEach(System.out::println);
		
		//Lifecycle
		
		SampleClassForEnv samp = ctx.getBean(SampleClassForEnv.class);
		System.out.println(samp);
	}
	
	

}
