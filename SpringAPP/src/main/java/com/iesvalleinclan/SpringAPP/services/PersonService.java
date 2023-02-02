package com.iesvalleinclan.SpringAPP.services;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.iesvalleinclan.SpringAPP.repositories.*;

@Service
public class PersonService {

	@Autowired
	private PersonRepository PersonRepository;

	public void deletePerson(String id) {

		PersonRepository.deleteById(id);

	}

}
