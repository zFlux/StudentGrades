package com.students.db.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.students.db.dao.GradeRepository;
import com.students.db.dao.StudentRepository;
import com.students.db.entity.Student;
import com.students.entity.StudentRecords;
import com.students.db.entity.Grade;

@Component
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	GradeRepository gradeRepository;
	
	public Student getStudent(String id) {
		Optional<Student> student = studentRepository.findById(id);
		List<Grade> grades = gradeRepository.findByStudentId(id);
		if (student.isPresent()) {
		    student.get().setGrades(grades);
        }
		return student.isPresent() ? student.get() : null;
	}
	
	public StudentRecords getStudents() {
		List<Student> students = studentRepository.findAll();
		StudentRecords record = new StudentRecords();
		record.setData(students);
		return record;
	}
	
	public List<Grade> getGradesById(String id) {
		return gradeRepository.findByStudentId(id);
	}
	
	public Grade getGradesByIdAndYear(String id, String year) {
		return gradeRepository.findByStudentIdAndYear(id, year);
	}

	public StudentRecords createStudents(StudentRecords studentRecords) {
		List<Student> students = studentRecords.getData();
		
		// Set the student id in all the grades records based on parent student record before update
		for(Student student : students) {
			List<Grade> grades = student.getGrades();
			String id = student.getId();
			for (Grade grade: grades) {
				grade.setStudentId(id);
				gradeRepository.save(grade);
			}
			
		}
		
		List<Student> returnStudents = studentRepository.saveAll(students);
		studentRecords.setData(returnStudents);
		return studentRecords;
	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(String id) {
		gradeRepository.deleteByStudentId(id);
		studentRepository.deleteById(id);
	}

	public Grade createGrade(Grade grade) {
		return gradeRepository.save(grade);
	}

	public Integer deleteGradesByIdAndYear(String id, String year) {
		return gradeRepository.deleteByStudentIdAndYear(id, year);
	}
}
