package com.students.db.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.students.db.dao.GradeRepository;
import com.students.db.dao.StudentRepository;
import com.students.db.entity.Student;
import com.students.entity.StudentRecords;
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
	
	public StudentRecords getStudents() {
		List<Student> students = studentRepository.findAll();
		StudentRecords record = new StudentRecords();
		record.setData(students);
		record.setVersion("1.00");
		return record;
	}
	
	public List<Grade> getGradesById(String id) {
		return gradeRepository.findByStudentId(id);
	}
	
	public Grade getGradesByIdAndYear(String id, String year) {
		return gradeRepository.findByStudentIdAndYear(id, year);
	}
	
	public List<Grade> getGrades() {
		return gradeRepository.findAll();
	}

	public StudentRecords createStudents(StudentRecords studentRecords) {
		// TODO Auto-generated method stub
		List<Student> students = studentRecords.getData();
		
		// Set the student id in all the grades records based on parent student record
		for(Student student : students) {
			
			Set<Grade> grads = student.getGrads();
			String id = student.getId();
			for (Grade grade: grads) {
				grade.setStudentId(id);
				gradeRepository.save(grade);
			}
			
			studentRepository.save(student);
		}
		
		List<Student> returnStudents = studentRepository.save(students);
		studentRecords.setData(returnStudents);
		return studentRecords;
	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Grade createGrade(Grade grade) {
		return gradeRepository.save(grade);
	}
	
}
