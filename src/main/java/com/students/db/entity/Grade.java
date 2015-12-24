package com.students.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.students.db.entity.id.GradeId;

import lombok.ToString;

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
	
    @Column(name = "year_result", nullable = false, length=10)
    private String year_result;
    
    @Column(name = "subject1", nullable = false, length=20)
    private String subject1;
    
    @Column(name = "subject2", nullable = false, length=20)
    private String subject2;
    
    @Column(name = "subject3", nullable = false, length=20)
    private String subject3;
    
    @Column(name = "subject4", nullable = false, length=20)
    private String subject4;
    
    @Column(name = "subject5", nullable = false, length=20)
    private String subject5;

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getGpi() {
		return gpi;
	}

	public void setGpi(Double gpi) {
		this.gpi = gpi;
	}

	public String getYear_result() {
		return year_result;
	}

	public void setYear_result(String yearResult) {
		this.year_result = yearResult;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	public String getSubject4() {
		return subject4;
	}

	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}

	public String getSubject5() {
		return subject5;
	}

	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}
	
}
