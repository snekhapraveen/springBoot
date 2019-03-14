package com.example.demo.service;

import java.util.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

interface BookService {

	public List<Book> getBooks();
	public Long addBook(Book bk);
}

@Repository
public class BookServiceImpl implements BookService{
	
	@Autowired
	EntityManagerFactory factory;
	@Override
	public List<Book> getBooks(){
		
		Session session = factory.unwrap(SessionFactory.class).openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Book> query = builder.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);		
		return session.createQuery(query).getResultList();
	}
	@Override
	public Long addBook(Book bk) {
		//Check for Hibernate version
		Session session = factory.unwrap(SessionFactory.class).openSession();//Using EntityManagerFactory to get session
		Long key =(Long)session.save(bk);
		session.beginTransaction().commit();
		return key;//Return type of save is Primary key of type Long object 
	}
}
