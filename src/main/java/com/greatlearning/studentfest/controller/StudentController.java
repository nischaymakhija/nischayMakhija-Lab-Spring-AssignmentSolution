package com.greatlearning.studentfest.controller;


import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentfest.entity.Student;
import com.greatlearning.studentfest.studentservice.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController() {
		System.out.println("The controller class");
	}

	@GetMapping("/list")
	public String studentList(Model theModel) {

		List<Student> theStudents = studentService.findAll();

		theModel.addAttribute("Student",theStudents);
		return "Student-list";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model theModel) {
		Student  theStudent= new Student();
		theModel.addAttribute("Student", theStudent);
		return "Student-form";

	}

//	@RequestMapping("/save")
//	public String saveStudent(Student theStudent) {
//		
//		studentService.save(theStudent);
//		return "redirect:/list";
//	}
	
//	@PostMapping("/save")
//	public String saveStudent(@RequestBody Student theStudent) {
//		int theId = theStudent.getStudentId();
//		System.out.println("Student Id: "+theId);
//		if(theId!=0) {
//			theStudent = studentService.FindById(theId).get();
//			theStudent.setName(theStudent.getName());
//			theStudent.setDepartment(theStudent.getDepartment());
//			theStudent.setCountry(theStudent.getCountry());
//		}
//		else
//			theStudent = new Student(theStudent.getName(),theStudent.getDepartment(),theStudent.getCountry());
//		studentService.save(theStudent);
//		return "redirect:/list";
//	}



	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int theId , 
			@RequestParam("name") String name , 
			@RequestParam("department") String department , 
			@RequestParam("country") String country){
		System.out.println("Student Id: "+theId);
		Student theStudent;
		
		if(theId!=0) {
			theStudent = studentService.FindById(theId).get();
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		}
		else
			theStudent = new Student(name,department,country);
		
		studentService.save(theStudent);
		
		return "redirect:/list";
	}		
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/list";
	}
//	@RequestMapping("/update")
//	public String updateStudent(@RequestParam("studentId") int theId, Model theModel) {
//		System.out.println("Updated Student ID: " +theId);
//		Optional<Student> theStudent=studentService.FindById(theId);
//		theModel.addAttribute("Student", theStudent.get());
//		return "Student-form";
//	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
			Model theModel) {

		// get the Book from the service
		Optional<Student> theStudent = studentService.FindById(theId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent.get());

		// send over to our form
		return "Student-form";			
	}
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
