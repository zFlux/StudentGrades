package com.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Sets up a servlet for the student web service
@Configuration
@EnableAutoConfiguration(exclude={AopAutoConfiguration.class, DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, ErrorMvcAutoConfiguration.class,
		HttpEncodingAutoConfiguration.class, PropertyPlaceholderAutoConfiguration.class,
		SpringDataWebAutoConfiguration.class, ServerPropertiesAutoConfiguration.class,
		PersistenceExceptionTranslationAutoConfiguration.class})
// ServerPropertiesAutoConfiguration sets up a necessary ServerProperties Bean


@ComponentScan(basePackages = {"com.students"})
public class StudentGradesApp  {

	public static void main(String[] args) {
		SpringApplication.run(StudentGradesApp.class);
	}
	
	


	

}


