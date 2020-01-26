package com.spring.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.models.Employee;


@Service
public class EmployeeService {
	
     public List<Employee> getAllEmployees(){
    	  List<Employee> emp = new ArrayList<Employee>();
         emp.add(new Employee("abdul",312,50000));
         emp.add(new Employee("akshar",32,100000));
         emp.add(new Employee("jaspreet",32,25000));
         
    	 return emp;
     }
}
