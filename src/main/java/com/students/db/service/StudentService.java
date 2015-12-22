package com.students.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.students.db.dao.GradeRepository;
import com.students.db.dao.StudentRepository;
import com.students.db.entity.Student;
import com.students.db.entity.Grade;

// Create a service to call for database operations 

@Component
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	GradeRepository gradeRepository;
	
	public Student getStudent(String id) {
		return studentRepository.findById(id);
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	public List<Grade> getGradesById(String id) {
		return gradeRepository.findByStudentId(id);
	}
	
	public List<Grade> getGrades() {
		return gradeRepository.findAll();
	}
	
}
