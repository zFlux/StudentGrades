package com.students.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.students.db.entity.Student;
import com.students.db.manager.StudentManager;

// Create a service to call for database operations 

@Component
public class StudentService {

	@Autowired
	StudentManager studentManager;
	
	// Initial operation to get all students
	public Student getAllStudents(String id) {
		return studentManager.getStudents(id);
	}
	
}
