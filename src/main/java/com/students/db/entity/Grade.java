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

@ToString(includeFieldNames = true)
@Entity
@Data
@IdClass(GradeId.class)
@Table(name = "grade")
public class Grade implements Serializable {
	
	private static final long serialVersionUID = -6554017341075396787L;

	@Id
	@Column(name = "studentId", length=10) 
	private String studentId;
	
	@Id
	@Column(name = "year")
	private String year;
	
    @Column(name = "gpi")
    private Double gpi;
	
    @Column(name = "year_result", nullable = false, length=10)
    private String yearResult;
    
    @Column(name = "subjectA", nullable = false, length=20)
    private String subjectA;
    
    @Column(name = "subjectB", nullable = false, length=20)
    private String subjectB;
    
    @Column(name = "subjectC", nullable = false, length=20)
    private String subjectC;
    
    @Column(name = "subjectD", nullable = false, length=20)
    private String subjectD;
    
    @Column(name = "subjectE", nullable = false, length=20)
    private String subjectE;
    
    public String getStudentId() {
    	return this.studentId;
    }
    
    public String getYear() {
    	return this.year;
    }
}
