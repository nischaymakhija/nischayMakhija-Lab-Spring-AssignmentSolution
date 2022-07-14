package com.greatlearning.studentfest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.studentfest.entity.Role;
import com.greatlearning.studentfest.entity.Student;
import com.greatlearning.studentfest.entity.User;
import com.greatlearning.studentfest.repository.RoleRepository;
import com.greatlearning.studentfest.repository.StudentRepository;
import com.greatlearning.studentfest.repository.UserRepository;

@SpringBootApplication
public class LabSessionApplication {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(LabSessionApplication.class, args);
	}

	@Bean
	public void createStudents() {

		Student std1 = new Student();
		std1.setName("Bindu");
		std1.setDepartment("BE");
		std1.setCountry("India");
		studentRepository.save(std1);

		Student std2 = new Student();
		std2.setName("Isha");
		std2.setDepartment("Music");
		std2.setCountry("Dubai");
		studentRepository.save(std2);

		Student std3 = new Student();
		std3.setName("Aditi");
		std3.setDepartment("Dance");
		std3.setCountry("India");
		studentRepository.save(std3);

		Role role1 = new Role();
		role1.setName("ROLE_ADMIN");
		roleRepository.save(role1);

		Role role2 = new Role();
		role2.setName("ROLE_USER");
		roleRepository.save(role2);

		User user1 = new User();
		user1.setUsername("abc");
		user1.setPassword(encoder().encode("abc"));
		user1.setRoles(Arrays.asList(role1, role2));

		userRepository.save(user1);

		User user2 = new User();
		user2.setUsername("xyz");
		user2.setPassword(encoder().encode("xyz"));
		user2.setRoles(Arrays.asList(role2));
		userRepository.save(user2);

	}
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}

}