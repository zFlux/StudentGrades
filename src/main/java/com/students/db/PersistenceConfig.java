package com.students.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "com.students.db.dao")
@EntityScan(basePackages = {"com.students.db"})
@PropertySource("classpath:persistence.properties")
public class PersistenceConfig  {
	
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(getDataSource());
		return txManager;
		
	}
	
	@Bean
	public OpenEntityManagerInViewFilter viewFilter() {
		OpenEntityManagerInViewFilter viewFilter = new OpenEntityManagerInViewFilter();
		viewFilter.setEntityManagerFactoryBeanName("entityManagerFactory");
		return viewFilter;
	}
	
	// Create a bean factory for creating JPA entity manager factories to be injected and used by DAO objects.
	// Populate it with JPA properties from the persistence.properties file
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(getDataSource());
        entityManager.setJpaVendorAdapter(vendorAdapter());

        return entityManager;
    }
    
    @Bean
    public JpaVendorAdapter vendorAdapter() {
    	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    	return vendorAdapter;
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
    public Properties properties() {
        return new Properties();
    }
    
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        return tomcat;
    }
    
	@Bean
	public ServerProperties serverProperties () {
		ServerProperties serverProperties = new ServerProperties();
		serverProperties.setContextPath("");
		serverProperties.setPort(8080);
		return serverProperties;
	}
	
	// Jackson Message Converters
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}
	
	// HttpMessageConverter
	@Bean
	public MappingJackson2HttpMessageConverter httpMessageConverter() {
		MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();
		return httpMessageConverter;
	}
	
	@Bean
	public StringHttpMessageConverter stringMessageConverter() {
		StringHttpMessageConverter stringMessageConverter = new StringHttpMessageConverter();
		return stringMessageConverter;
	}
	
	@Bean
	public HttpMessageConverters messageConverters() {		
		HttpMessageConverters messageConverters = new HttpMessageConverters();
		return messageConverters;
	}
	
	// Persistence Exception 
	@Bean
	PersistenceExceptionTranslationPostProcessor exceptionProcessor() {
		PersistenceExceptionTranslationPostProcessor exceptionProcessor = new PersistenceExceptionTranslationPostProcessor();
		return exceptionProcessor;
	}
	
	
	@Bean
	ServletRegistrationBean servletRegistration() {
		ServletRegistrationBean servletRegistration = new ServletRegistrationBean();
	       AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		DispatcherServlet servlet = new DispatcherServlet(rootContext);
		servletRegistration.setServlet(servlet);
		return servletRegistration;
	}
    
}