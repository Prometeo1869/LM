package com.hg.microservices.models.dto;

import java.util.List;

import com.hg.microservices.models.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TeacherDTO extends PersonDTO{

	private String degree;

	private Double salary;
	
	private List<Course> courses;
	
	@Override
	public String toString() {
		return "Teacher [id: " + getId() + ", Nombre: " + getName() + ", Género:" + this.getGender() + ", Dir.: " + this.degree + ", Salario: " + this.getSalary() +"]";
	}
}
