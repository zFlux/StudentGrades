package com.students.db;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "com.students.db.dao")
@EntityScan(basePackages = {"com.students.db"})
@PropertySource("classpath:persistence.properties")
public class PersistenceConfig {
	
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
	// Servlet Configuration
	
	// Dispatch Servlet
	@Bean
	DispatcherServlet servlet() {
	       AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	       DispatcherServlet servlet = new DispatcherServlet(rootContext);
	       return servlet;
	}
	
	// Embedded Servlet Container
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        return tomcat;
    }
	
	//*************************************************
	// Web Model View Controller Configuration
    
	// Creates RequestMappingInfo instances from type and method-level @RequestMapping annotations in @Controller classes.
	@Bean
	public RequestMappingHandlerMapping handlerMapping() {
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		return handlerMapping;
	}
	
	// Adapter for request mappings - e.g. adds converter adapters to go from json to java object and vice versa
	@Bean
	public RequestMappingHandlerAdapter handlerAdapter() {
		RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJackson2HttpMessageConverter());
		handlerAdapter.setMessageConverters(converters);
		return handlerAdapter;
	}
    
}