package com.hg.microservices.models.dto;

import java.util.List;

import com.hg.microservices.models.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDTO extends PersonDTO {

	private Boolean schoolarship;
	
	private Integer state;
	
	List<Course> enrolled_courses;

	@Override
	public String toString() {
		return "id: " + getId() + ", Nombre: " + getName() + ", Escolarizado:" + ((schoolarship == true) ? " Si" : " No") + ", Estado:" + state + "";
	}
	
	
}
