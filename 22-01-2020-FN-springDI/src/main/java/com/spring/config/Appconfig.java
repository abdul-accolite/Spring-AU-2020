package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.spring.models.Point;
@Configuration
@PropertySource("file:src/main/resources/application.properties")
public class Appconfig {

	  @Autowired
	  private Environment environ;
	  @Bean(name="dot")
	  public Point display_point() {
		  System.out.println("printing using properties file");
		  Point point= new Point(Integer.parseInt(this.environ.getProperty("count")),Integer.parseInt(this.environ.getProperty("size")));
		  return point;
	  }
}
