package com.hg.microservices.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
        
        /* Eliminando esta notación, al acceder al JSON de profesores obtienes los datos de los cursos con sus atributos. Cada curso tiene un
         * un profesor asignado que a su vez tiene una lista de cursos. Entramos en un bucle de objetos. Por lo tanto,
         * hay que añadir la etiqueta @JsonIgnoreProperties("teacher") para cortar el buble de datos anidados.
         @JsonIdentityInfo(
                        generator = ObjectIdGenerators.PropertyGenerator.class,
                        property = "key"
                        )
        */
        @JsonIgnoreProperties("teacher")
        @JsonIdentityReference(alwaysAsId = true)
        @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Course> courses;

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

        public static long getSerialversionuid() {
                return serialVersionUID;
        }

        public List<Course> getCourses() {
                return courses;
        }

        public void setCourses(List<Course> courses) {
                this.courses = courses;
        }
        
        
}