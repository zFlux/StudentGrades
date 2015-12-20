package com.students.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.students.db.entity.Grade;
import com.students.db.entity.id.GradeId;

@Repository
@Transactional
public interface GradesRepository extends JpaRepository<Grade, GradeId>{
	
	public List<Grade> findById(String id);
}
