package com.greatlearning.studentfest.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	
	private String name;
	private String department;
	private String country;
	public Student(String name, String department, String country) {
		super();
		this.name=name;
		this.country=country;
		this.department=department;
	}
	
}
