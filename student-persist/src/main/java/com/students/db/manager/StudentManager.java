package com.students.db.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.students.db.dao.StudentRepository;
import com.students.db.entity.Student;

@Component
public class StudentManager {

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudents(String id) {
		return studentRepository.findOne(id);
	}
	
}
