package com.students.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.students.db.entity.id.GradeId;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
@Entity
@IdClass(GradeId.class)
@Table(name = "grade")
public class Grade implements Serializable {
	
	private static final long serialVersionUID = -6554017341075396787L;
	
	@Id
	@Column(name = "studentId")
	private String studentId;
	
	@Id
	@Column(name = "year")
	private String year;
	
    @Column(name = "gpi")
    private Double gpi;
	
    @Column(name = "year_result", nullable = false)
    private String year_result;
    
    @Column(name = "subject1", nullable = false)
    private String subject1;
    
    @Column(name = "subject2", nullable = false)
    private String subject2;
    
    @Column(name = "subject3", nullable = false)
    private String subject3;
    
    @Column(name = "subject4", nullable = false)
    private String subject4;
    
    @Column(name = "subject5", nullable = false)
    private String subject5;
	
}
