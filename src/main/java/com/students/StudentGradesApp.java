package com.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.sql.DataSource;

// Sets up a servlet for the student web service
@SpringBootApplication
public class StudentGradesApp{
	
	public static void main(String[] args) {
		SpringApplication.run(StudentGradesApp.class, args);
	}


	//*************************************************
	// Persistence Configuration

    // Database connection
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        return new DriverManagerDataSource();
    }

	// Spring's database transaction management bean injected with Database connection from above
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(getDataSource());
		return txManager;
	}

	// Database entity manager set to use Java Persistence API with Hibernate as the persistence provider on
	// the above data source
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(getDataSource());
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManager.setPackagesToScan("com.students.db");
        return entityManager;
    }

    // Filter that injects the entity manager as a servlet view
	@Bean
	public OpenEntityManagerInViewFilter viewFilter() {
		OpenEntityManagerInViewFilter viewFilter = new OpenEntityManagerInViewFilter();
		viewFilter.setEntityManagerFactoryBeanName("entityManagerFactory");
		return viewFilter;
	}

	//*************************************************
	// Logging Configuration

	@Bean
	public CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter
				= new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(10000);
		filter.setIncludeHeaders(false);
		return filter;
	}


}


