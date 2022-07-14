package com.greatlearning.studentfest.studentserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentfest.entity.Student;
import com.greatlearning.studentfest.repository.StudentRepository;
import com.greatlearning.studentfest.studentservice.StudentService;

@Service
public class SudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		List<Student> student= studentRepository.findAll();
		return student;
	}

	@Override
	public Optional<Student> FindById(int theId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(theId);
	}

	@Override
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(theId);
	}
	
	
}
