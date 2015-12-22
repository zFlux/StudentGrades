package com.students.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.students.db.dao.GradesRepository;
import com.students.db.dao.StudentRepository;
import com.students.db.entity.Student;
import com.students.db.entity.Grade;

// Create a service to call for database operations 

@Component
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	GradesRepository gradesRepository;
	
	public Student getStudent(String id) {
		return studentRepository.findOne(id);
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	public List<Grade> getGradesById(String id) {
		return gradesRepository.findByStudentId(id);
	}
	
	public List<Grade> getGrades() {
		return gradesRepository.findAll();
	}
	
}
