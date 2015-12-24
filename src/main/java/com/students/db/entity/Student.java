package com.students.db.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@ToString(includeFieldNames = true)
@Entity
@Data
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = -8915947718619112697L;

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
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="studentId", referencedColumnName="id")
    private Set<Grade> grads;
    
    public void setGrade(Grade grade) {
    	this.grads.add(grade);
    }
    
} 
