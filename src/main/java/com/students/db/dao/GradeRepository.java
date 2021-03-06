package com.students.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.students.db.entity.Grade;
import com.students.db.entity.id.GradeId;

@Repository
@Transactional
public interface GradeRepository extends JpaRepository<Grade, GradeId>{
	
	List<Grade> findByStudentId(String studentId);
	
	Grade findByStudentIdAndYear(String studentId, String year);

	Integer deleteByStudentIdAndYear(String studentId, String year);

	Integer deleteByStudentId(String studentId);

}
