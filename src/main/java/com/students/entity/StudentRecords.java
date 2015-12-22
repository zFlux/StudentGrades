package com.students.entity;

import java.util.List;
import com.students.db.entity.Student;

import lombok.Data;

@Data
public class StudentRecords {
	String version;
	List<Student> data;
}
