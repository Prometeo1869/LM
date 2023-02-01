package com.iesvalleinclan.SpringAPP.models;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.CascadeType;
import java.io.*;
import java.util.*;
import java.time.*;

@Entity(name = "Course")
@Table(name = "\"Courses\"", schema = "public")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "key")
	private Long key;

	@ManyToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_course_teacher", foreignKeyDefinition = "FOREIGN KEY (teacher_id)\r\n"
			+ "				REFERENCES public.\"Teachers\" (id) MATCH SIMPLE\r\n"
			+ "				ON UPDATE CASCADE\r\n"
			+ "				ON DELETE CASCADE", value = ConstraintMode.CONSTRAINT))
	private Teacher teacher;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "start_date", nullable = false, columnDefinition = "date DEFAULT 'now ()'")
	private LocalDate start_date = ZonedDateTime.now(ZoneId.of("America/Guayaquil")).toLocalDate();

	@Column(name = "ending_date", nullable = false)
	private LocalDate ending_date;

	@ManyToMany(mappedBy = "enrolled_courses", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Student> enrolled_students;

	public static long getSerialversionuid() {

		return serialVersionUID;

	}

	public Long getKey() {

		return key;

	}

	public void setKey(Long key) {

		this.key = key;

	}

	public Teacher getTeacher() {

		return teacher;

	}

	public void setTeacher(Teacher teacher) {

		this.teacher = teacher;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public LocalDate getStart_date() {

		return start_date;

	}

	public void setStart_date(LocalDate start_date) {

		this.start_date = start_date;

	}

	public LocalDate getEnding_date() {

		return ending_date;

	}

	public void setEnding_date(LocalDate ending_date) {

		this.ending_date = ending_date;

	}

	public List<Student> getEnrolled_students() {

		return enrolled_students;

	}

	public void setEnrolled_students(List<Student> enrolled_students) {

		this.enrolled_students = enrolled_students;

	}

}
