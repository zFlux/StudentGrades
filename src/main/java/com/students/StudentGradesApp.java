package com.students;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Sets up a servlet for the student web service
@Configuration
@ComponentScan(basePackages = {"com.students"})
public class StudentGradesApp{
	
	public static void main(String[] args) {
		SpringApplication.run(StudentGradesApp.class);
	}

}


