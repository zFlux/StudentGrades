package com.students.db.entity.id;

import java.io.Serializable;

import lombok.Data;

@Data
public class GradeId implements Serializable {

	private static final long serialVersionUID = 3498199443685446187L;
	private String studentId;
	private String year;
}
