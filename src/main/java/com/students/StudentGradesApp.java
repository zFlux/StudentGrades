package com.students;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Sets up a servlet for the student web service
@Configuration
//@EnableAutoConfiguration(exclude={AopAutoConfiguration.class, DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class, ErrorMvcAutoConfiguration.class,
//		HttpEncodingAutoConfiguration.class, PropertyPlaceholderAutoConfiguration.class,
//		SpringDataWebAutoConfiguration.class, ServerPropertiesAutoConfiguration.class,
//		PersistenceExceptionTranslationAutoConfiguration.class, 
//		MultipartAutoConfiguration.class,
//		JtaAutoConfiguration.class, JpaBaseConfiguration.class, HibernateJpaAutoConfiguration.class,
//		JndiDataSourceAutoConfiguration.class, JmxAutoConfiguration.class, JacksonAutoConfiguration.class,
//		HttpMessageConvertersAutoConfiguration.class, EmbeddedServletContainerAutoConfiguration.class,
//		WebMvcAutoConfiguration.class, DispatcherServletAutoConfiguration.class})
// ServerPropertiesAutoConfiguration sets up a necessary ServerProperties Bean
// HibernateJpaAutoConfiguration set up neccessary PlatformTransactionManager Bean
// JpaBaseConfiguration


@ComponentScan(basePackages = {"com.students"})
public class StudentGradesApp{
	
	public static void main(String[] args) {
		SpringApplication.run(StudentGradesApp.class);
	}

}


