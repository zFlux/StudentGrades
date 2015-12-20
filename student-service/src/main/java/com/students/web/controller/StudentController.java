package com.students.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.students.db.entity.Student;
import com.students.db.service.StudentService;

// Basic controller to eventually consume students JSON as well as return JSON

@RestController
@RequestMapping(consumes = {APPLICATION_JSON_VALUE}, produces = APPLICATION_JSON_VALUE)
public class StudentController {

	//TODO: Working on issues with hooking in the persistence layer here 
	
	@Autowired
	StudentService studentService;
	
    ///////////////////////////////////////////////////////////////////////////
    // Students
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<?> getStudents(@RequestParam(value = "id", required = false) String id) {
    	
    	Student student = studentService.getAllStudents(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

}
