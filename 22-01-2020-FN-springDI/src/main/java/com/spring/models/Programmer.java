package com.spring.models;
import java.util.HashMap;
import java.util.Map;

public class Programmer {
   private int id;
   private String name;
   private HashMap<Integer,Employee>prog;
   public Programmer(int id, String name,HashMap<Integer,Employee> prog)
   {
	   this.id=id;
	   this.name=name;
	   this.prog=prog;
   }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public HashMap<Integer, Employee> getProg() {
	return prog;
}
public void setProg(HashMap<Integer, Employee> prog) {
	this.prog = prog;
}
public void display() {
	for(Map.Entry me: prog.entrySet()) {
		System.out.println(me.getKey() + "   "+ me.getValue());
	}
}
   
}