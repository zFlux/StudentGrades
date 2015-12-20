package com.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Sets up a servlet for the student web service
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.students"})
public class StudentGradesApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StudentGradesApp.class);
	}
}


