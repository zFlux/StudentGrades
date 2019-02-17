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
	public StudentRecords getStudents() {
		return studentService.getStudents();
	}
	
	@RequestMapping(value = "/student_records", method = RequestMethod.POST)
	public StudentRecords createStudents(@RequestBody StudentRecords studentRecords) {
		return studentService.createStudents(studentRecords);
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Student
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable String id) {
		return studentService.getStudent(id);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Grade

	@RequestMapping(value = "/grade/{id}", method = RequestMethod.GET)
	public List<Grade> getGradesById(@PathVariable String id) {
		return studentService.getGradesById(id);
	}
	
	@RequestMapping(value = "/grade/{id}/{year}", method = RequestMethod.GET)
	public Grade getGradeByIdAndYear(@PathVariable String id, @PathVariable String year) {
		return studentService.getGradesByIdAndYear(id, year);
	}

	@RequestMapping(value = "/grade/{id}/{year}", method = RequestMethod.DELETE)
	public Integer deleteGradeByIdAndYear(@PathVariable String id, @PathVariable String year) {
		return studentService.deleteGradesByIdAndYear(id, year);
	}

	@RequestMapping(value = "/grade", method = RequestMethod.POST)
	public Grade createGrade(@RequestBody Grade grade) {
		return studentService.createGrade(grade);
	}

}
