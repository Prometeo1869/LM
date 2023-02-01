package com.iesvalleinclan.SpringAPP.models;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.CascadeType;
import org.hibernate.annotations.*;
import java.io.*;
import java.util.*;

@Entity(name = "Teacher")
@Table(name = "\"Teachers\"", schema = "public")
@OnDelete(action = OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_teacher_person"))
public class Teacher extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "degree", nullable = false)
	private String degree;

	@Column(name = "salary", nullable = false)
	private Double salary;

	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Course> courses;

	public static long getSerialversionuid() {

		return serialVersionUID;

	}

	public String getDegree() {

		return degree;

	}

	public void setDegree(String degree) {

		this.degree = degree;

	}

	public Double getSalary() {

		return salary;

	}

	public void setSalary(Double salary) {

		this.salary = salary;

	}

	public List<Course> getCourses() {

		return courses;

	}

	public void setCourses(List<Course> courses) {

		this.courses = courses;

	}

	public String toString() {

		return "Teacher {ID: " + getId() + ", Name: " + getName() + ", Gender: " + getGender() + ", Email: "
				+ getEmail() + ", Degree: " + getDegree() + ", Salary: " + getSalary() + ", Courses: " + getCourses () + "}\n";

	}

}
