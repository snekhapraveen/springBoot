package com.example.demo.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CalculateTime {

	@Around("@annotation(com.example.demo.utils.ShowExecutionTime)")//Specify full path to avoid error
	public Object countTime(ProceedingJoinPoint pjp)throws Throwable{
		long current = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long timeElapsed = System.currentTimeMillis() - current;
		System.out.println("Method completed in : " + timeElapsed);
		return obj;
	}
}
