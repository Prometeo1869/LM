package com.iesvalleinclan.SpringAPP.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.iesvalleinclan.SpringAPP.services.*;
import com.iesvalleinclan.SpringAPP.models.*;
import org.springframework.validation.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/colegio")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private PersonService personService;

	@PostMapping("/profesor")
	public Teacher createTeacher(@Validated @RequestBody Teacher teacher) {

		return teacherService.saveTeacher(teacher);

	}

	@GetMapping("/profesores")
	public List<Teacher> readTeachers() {

		return teacherService.getAllTeachers();

	}

	@PutMapping("/profesor/{id}")
	public Teacher updateTeacher(@PathVariable String id, @Validated @RequestBody Teacher teacher) {

		return teacherService.saveTeacher(teacher);

	}

	@DeleteMapping("/profesor/{id}")
	public void deleteTeacher(@PathVariable String id) {

		personService.deletePerson(id);

	}

}
