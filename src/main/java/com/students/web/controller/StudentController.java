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

// Basic controller to eventually consume students JSON as well as return JSON

@RestController
@RequestMapping(consumes = { APPLICATION_JSON_VALUE }, produces = APPLICATION_JSON_VALUE)
public class StudentController {

	// TODO: Working on issues with hooking in the persistence layer here

	@Autowired
	StudentService studentService;

	///////////////////////////////////////////////////////////////////////////
	// Students

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<?> getStudents() {

		StudentRecords students = studentService.getStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<?> createStudents(@RequestBody StudentRecords studentRecords) {

		StudentRecords students = studentService.createStudents(studentRecords);
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@RequestMapping(value = "/grades/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getGradesById(@PathVariable String id) {

		List<Grade> grades = studentService.getGradesById(id);
		return new ResponseEntity<>(grades, HttpStatus.OK);
	}

	@RequestMapping(value = "/grades", method = RequestMethod.GET)
	public ResponseEntity<?> getGrades() {

		List<Grade> grades = studentService.getGrades();
		return new ResponseEntity<>(grades, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getStudent(@PathVariable String id) {

		Student student = studentService.getStudent(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

}
