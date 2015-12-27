package com.students.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.students.db.entity.Student;
import com.students.db.entity.Grade;
import com.students.db.service.StudentService;
import com.students.entity.StudentRecords;

@RestController
@RequestMapping(consumes = { APPLICATION_JSON_VALUE }, produces = APPLICATION_JSON_VALUE)
public class StudentController {

	@Autowired
	StudentService studentService;

	///////////////////////////////////////////////////////////////////////////
	// Student Records

	@RequestMapping(value = "/student_records", method = RequestMethod.GET)
	public ResponseEntity<?> getStudents() {

		StudentRecords students = studentService.getStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/student_records", method = RequestMethod.POST)
	public ResponseEntity<?> createStudents(@RequestBody StudentRecords studentRecords) {

		StudentRecords students = studentService.createStudents(studentRecords);
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Student
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getStudent(@PathVariable String id) {

		Student student = studentService.getStudent(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public ResponseEntity<?> createStudent(@RequestBody Student student) {

		Student returnStudent = studentService.createStudent(student);
		return new ResponseEntity<>(returnStudent, HttpStatus.OK);
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Grade

	@RequestMapping(value = "/grade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getGradesById(@PathVariable String id) {

		List<Grade> grades = studentService.getGradesById(id);
		return new ResponseEntity<>(grades, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/grade/{id}/{year}", method = RequestMethod.GET)
	public ResponseEntity<?> getGradesByIdAndYear(@PathVariable String id, @PathVariable String year) {

		Grade grade = studentService.getGradesByIdAndYear(id, year);
		return new ResponseEntity<>(grade, HttpStatus.OK);
	}

	@RequestMapping(value = "/grade", method = RequestMethod.POST)
	public ResponseEntity<?> createGrade(@RequestBody Grade grade) {

		Grade returnGrade = studentService.createGrade(grade);
		return new ResponseEntity<>(returnGrade, HttpStatus.OK);
	}



}
