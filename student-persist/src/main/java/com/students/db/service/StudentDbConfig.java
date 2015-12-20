package com.students.db.service;
 
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
 
@ComponentScan(basePackages = {"com.students"})
@Configuration
@EnableJpaRepositories(basePackages = "com.students.db.dao")
@EntityScan(basePackages = {"com.students.db"})
public class StudentDbConfig {
 
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
 
    @Bean(name = "faultTolerantRestTemplate")
    public RestTemplate faultTolerantRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
 
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertiesConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
 
}