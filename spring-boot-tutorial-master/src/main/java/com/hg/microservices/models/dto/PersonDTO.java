package com.hg.microservices.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonDTO {

private String id;
	
	private String name;
	
	private String gender;
	
	private String email;
}
