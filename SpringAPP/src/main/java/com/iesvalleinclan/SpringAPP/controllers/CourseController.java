package com.iesvalleinclan.SpringAPP.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.iesvalleinclan.SpringAPP.services.*;
import com.iesvalleinclan.SpringAPP.models.*;
import org.springframework.validation.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/colegio")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/curso")
	public Course createCourse(@Validated @RequestBody Course course) {

		return courseService.saveCourse(course);

	}

	@GetMapping("/cursos")
	public List<Course> readCourses() {

		return courseService.getAllCourses();

	}

	@PutMapping("/curso/{id}")
	public Course updateCourse(@PathVariable String id, @Validated @RequestBody Course course) {

		return courseService.saveCourse(course);

	}

	@DeleteMapping("/curso/{id}")
	public void deleteCourse(@PathVariable Long id) {

		courseService.deleteCourse(id);

	}

}
