package com.students.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.students.db.dao.StudentRepository;
import com.students.db.entity.Student;

// Create a service to call for database operations 

@Component
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudents(String id) {
		return studentRepository.findOne(id);
	}
	
}
