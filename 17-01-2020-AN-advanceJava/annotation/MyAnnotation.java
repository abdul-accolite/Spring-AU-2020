package assignment.annotation;
// example of full annotation.
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //annotations help in developing annotations
@Target(ElementType.METHOD) 
public @interface MyAnnotation {
	int myValue() default 101;
	int myId() ;
}

class Hello{  
@MyAnnotation(myValue=10,myId=1)  
public void sayHello(){System.out.println("hello annotation");}  
}

class HelloDefault{  
@MyAnnotation(myId=2)
public void sayHello(){System.out.println("Default hello annotation");}  
} 
	
