package com.spring.demo;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.config.Appconfig;

import com.spring.models.Employee;
import com.spring.models.Point;
import com.spring.models.Programmer;
import com.spring.services.*;
@ComponentScan(basePackages="com.spring.models")
public class Main {
   public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); 
        System.out.println("print all employees");
		EmployeeService empser=context.getBean(EmployeeService.class);
		List<Employee>emp=empser.getAllEmployees();
		for(Employee em:emp)
		{
			System.out.println(em.getId()+":id,"+em.getName()+":name,"+em.getSal()+":salary");
		}
		System.out.println("\n\n2. map using constructor");
		Programmer prog =(Programmer)context.getBean(Programmer.class);
    	
        prog.display();
		System.out.println("\n\ninjection using property file");
ApplicationContext pointContext = new AnnotationConfigApplicationContext(Appconfig.class);
    	
    	Point p=(Point) pointContext.getBean("dot");
        System.out.println(p.getX()+"  "+p.getY());
   }
}
