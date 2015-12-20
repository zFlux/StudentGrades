package com.students.db.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID", nullable = false, length=150)
    private String ID;

    @Column(name = "FIRSTNAME", length = 150)
    private String FIRSTNAME;
    
    public String getFirstName() {
    	return FIRSTNAME;
    }
    
    public String getID() {
    	return ID;
    }
    
    public void setFirstName(String firstName) {
    	this.FIRSTNAME = firstName;
    }
    
    public void setId(String ID) {
    	this.ID = ID;
    }
} 
