package org.sistema.spring.jdbc.models;

/**
 * Client representation
 *
 * @author Eugenia Pérez Martínez
 * @email eugenia_perez@cuatrovientos.org
 */

public class Client {

    private Integer id;
    private String name;
    private String country;
    private String phone;
    private Integer age;

    public Integer getId () {

        return id;

    }

    public void setId (Integer id) {

        this.id = id;

    }

    public String getName () {

        return name;

    }

    public void setName (String name) {

        this.name = name;

    }

    public String getCountry () {

        return country;

    }

    public void setCountry (String country) {

        this.country = country;

    }

    public String getPhone () {

        return phone;

    }

    public void setPhone (String phone) {

        this.phone = phone;

    }

    public Integer getAge () {

        return age;

    }

    public void setAge (Integer age) {

        this.age = age;

    }

}
