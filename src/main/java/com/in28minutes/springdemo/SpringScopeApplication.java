package com.in28minutes.springdemo;

import com.in28minutes.springdemo.basic.BinarySearchImpl;
import com.in28minutes.springdemo.scope.PersonDao;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SpringBootApplication
public class SpringScopeApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringScopeApplication.class);
		PersonDao personDao = applicationContext.getBean(PersonDao.class);
	}
}
