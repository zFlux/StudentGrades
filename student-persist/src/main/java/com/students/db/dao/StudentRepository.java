package com.students.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.students.db.entity.Student;

// Repository for accessing Student objects through JPA to the HSQL instance
@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, String> {

}
