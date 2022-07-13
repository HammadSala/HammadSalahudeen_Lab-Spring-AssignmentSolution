package com.greatlearning.stumanagement.StudentManagement1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.stumanagement.StudentManagement1.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
