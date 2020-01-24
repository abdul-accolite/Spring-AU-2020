package assignment.annotation;

import java.lang.reflect.Method;

public class TestCustomAnnotation1 {
	  
	public static void main(String args[])throws Exception{  
	  
	Hello h=new Hello();  
	Method m=h.getClass().getMethod("sayHello"); 
	System.out.println("this is example of full annotation in java");
	  
	MyAnnotation manno=m.getAnnotation(MyAnnotation.class);  
	System.out.println("value is: "+manno.myValue());  
	System.out.println("id is: "+manno.myId());  
	
	HelloDefault h2= new HelloDefault();
	Method m2=h2.getClass().getMethod("sayHello");  
	  
	MyAnnotation manno2=m2.getAnnotation(MyAnnotation.class);  
	System.out.println("value is: "+ manno2.myValue()); 
	System.out.println("id is: "+manno2.myId());  
	}
}
