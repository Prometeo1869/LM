package com.iesvalleinclan.SpringAPP.services;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.iesvalleinclan.SpringAPP.repositories.*;
import com.iesvalleinclan.SpringAPP.models.*;
import java.util.*;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository TeacherRepository;

	public Teacher saveTeacher(Teacher teacher) {

		return TeacherRepository.save(teacher);

	}

	public List<Teacher> getAllTeachers() {

		return TeacherRepository.findAll();

	}

}
