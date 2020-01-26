package com.spring.models;

public class Employee {
 private String name;
 private int id;
 private int sal;
 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}
public Employee(String name, int id, int sal) {
	super();
	this.name = name;
	this.id = id;
	this.sal = sal;
}
public Employee(){
	 
}
@Override
public String toString() {
	return "empid="+this.getId()+"  name=  "+this.getName()+"   sal="+this.getSal();
	
}
}