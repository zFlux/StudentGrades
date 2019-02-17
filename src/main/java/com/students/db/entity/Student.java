package com.students.db.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
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
import org.springframework.format.annotation.DateTimeFormat;


@ToString(includeFieldNames = true)
@Entity
@Data
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = -8915947718619112697L;

	@Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "dob")
    private String dob;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "cpi")
    private Double cpi;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="studentId", referencedColumnName="id")
    private List<Grade> grades;
    
} 
