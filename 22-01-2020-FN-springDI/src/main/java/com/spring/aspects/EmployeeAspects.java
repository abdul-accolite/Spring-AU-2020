package com.spring.aspects;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspects {
	LocalDateTime now,now1;
	
	@Before("execution(* com.spring.services.EmployeeService.getAllEmployees(..))")
	public void logBeforeV1(JoinPoint joinPoint) {
		now=LocalDateTime.now();

			}
	@After("execution(* com.spring.services.EmployeeService.getAllEmployees(..))")
	public void logAfterV2(JoinPoint joinPoint) {
		now1 = LocalDateTime.now();
		long millis=now.until(now1, ChronoUnit.MILLIS);
		System.out.println("total time for execution of getAllEmployees method :"+millis+" :milliseconds");
	}
}
