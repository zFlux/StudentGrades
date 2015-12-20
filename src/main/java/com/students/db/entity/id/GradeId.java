package com.students.db.entity.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class GradeId implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String year;
}
