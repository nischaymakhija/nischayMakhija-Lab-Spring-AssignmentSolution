package com.greatlearning.studentfest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentfest.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
