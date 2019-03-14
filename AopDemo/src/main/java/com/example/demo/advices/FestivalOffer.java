package com.example.demo.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class FestivalOffer {

	//Advices
	@Before("execution(* com.example.demo.domains.*.* (..))")
	public void pongalOffer(JoinPoint jp) {
		log.info("#######Pongal offer called on " + jp);
	}
	
	@Around("execution(* com.example.demo.domains.*.* (..))")
	public Object pongalOffer(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("First part of Around advice called!");
		Object obj = jp.proceed();
		if(obj instanceof Number) {
		Double current = (Double)obj;
		obj = current + 0.5;
		}
		System.out.println("Second part of Around advice called!!!!");
		return obj;
	}
}
