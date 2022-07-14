package com.greatlearning.studentfest.studentservice;

import java.util.List;
import java.util.Optional;

import com.greatlearning.studentfest.entity.Student;

public interface StudentService {
	public List<Student> findAll();
	
	public Optional<Student> FindById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
	
}
