package com.iesvalleinclan.SpringAPP.services;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.iesvalleinclan.SpringAPP.repositories.*;
import com.iesvalleinclan.SpringAPP.models.*;
import java.util.*;

@Service
public class CourseService {

	@Autowired
	private CourseRepository CourseRepository;

	public Course saveCourse(Course course) {

		return CourseRepository.save(course);

	}

	public List<Course> getAllCourses() {

		return CourseRepository.findAll();

	}

	public void deleteCourse(Long id) {

		CourseRepository.deleteById(id);

	}

}
