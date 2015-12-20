package com.students.db;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.students.db.dao")
@EntityScan(basePackages = {"com.students.db"})
@PropertySource("classpath:persistence.properties")
public class PersistenceConfig {

	// Create a bean factory for creating JPA entity manager factories to be injected and used by DAO objects.
	// Populate it with JPA properties from the persistence.properties file
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(getDataSource());

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);
        Properties jpaProperties = jpaProperties();
        entityManager.setJpaProperties(jpaProperties);

        return entityManager;
    }

    // Create a bean which is a factory for creating data source connections. In this case populate it
    // With datasource configuration for an HSQL database (configuration is set in spring.datasource variables
    // in persistence.properties file
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        return new DriverManagerDataSource();
    }

    // Bean for retrieving JPA properties - JPA properties are set to work with HSQL 
    @Bean
    @ConfigurationProperties(prefix = "spring.jpa")
    public Properties jpaProperties() {
        return new Properties();
    }
    
}