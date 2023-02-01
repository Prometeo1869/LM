package com.iesvalleinclan.SpringAPP.services;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.iesvalleinclan.SpringAPP.repositories.*;
import com.iesvalleinclan.SpringAPP.models.*;
import java.util.*;

@Service
public class StudentService {

	@Autowired
	private StudentRepository StudentRepository;

	public Student saveStudent(Student student) {

		return StudentRepository.save(student);

	}

	public List<Student> getAllStudents() {

		return StudentRepository.findAll();

	}

}
