package com.students.db.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id", nullable = false, length=10)
    private String id;

    @Column(name = "name", length = 150)
    private String name;
    
    @Column(name = "dob")
    private Date dob;
    
    @Column(name = "status", length = 50)
    private String status;
    
    @Column(name = "cpi")
    private Double cpi;
    
} 
