package com.iesvalleinclan.SpringAPP.models;

import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "\"Persons\"", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

	@Id
	@Column(name = "id", length = 10)
	private String id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "gender", nullable = false, length = 1)
	private String gender;

	@Column(name = "email", nullable = false)
	private String email;

	public String getId() {

		return id;

	}

	public void setId(String id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getGender() {

		return gender;

	}

	public void setGender(String gender) {

		this.gender = gender;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

}
