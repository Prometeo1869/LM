package com.iesvalleinclan.SpringAPP.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.iesvalleinclan.SpringAPP.services.*;
import com.iesvalleinclan.SpringAPP.models.*;
import org.springframework.validation.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/colegio")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private PersonService personService;

	@PostMapping("/estudiante")
	public Student createStudent(@Validated @RequestBody Student student) {

		return studentService.saveStudent(student);

	}

	@GetMapping("/estudiantes")
	public List<Student> readStudents() {

		return studentService.getAllStudents();

	}

	@PutMapping("/estudiante/{id}")
	public Student updateStudent(@PathVariable String id, @Validated @RequestBody Student student) {

		return studentService.saveStudent(student);

	}

	@DeleteMapping("/estudiante/{id}")
	public void deleteStudent(@PathVariable String id) {

		personService.deletePerson(id);

	}

}
