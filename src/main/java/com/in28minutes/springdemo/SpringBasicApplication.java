package com.in28minutes.springdemo;

import com.in28minutes.springdemo.basic.BinarySearchImpl;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringBasicApplication {

	public static void main(String[] args) {

		//ApplicationContext applicationContext =  SpringApplication.run(SpringBasicApplication.class, args);
		try(AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(SpringBasicApplication.class)) {
			BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
			binarySearch.search(new int[]{1, 3, 4}, 9);
		}
	}
}
