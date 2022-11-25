package org.sistema.spring.jdbc.dao.impl;

import java.util.List;
import javax.sql.DataSource;
import org.sistema.spring.jdbc.dao.ClientDAO;
import org.sistema.spring.jdbc.mappers.ClientMapper;
import org.sistema.spring.jdbc.models.Client;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC Implementation of ClientDAO
 *
 * @author Eugenia Pérez Martínez
 * @email eugenia_perez@cuatrovientos.org
 */

public class JdbcClientDAO implements ClientDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource (DataSource dataSource) {

        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);

    }

    public void insert (String name, String country, String phone, Integer age) {

        String SQL = "insert into Client (name, country, phone, age) values (?, ?, ?, ?)";

        jdbcTemplateObject.update (SQL, name, country, phone, age);

        System.out.println("Created Record Name: " + name + " Country: " + country + " Phone: " + phone + " Age: " + age);

    }

    public void delete(Integer id) {

        String SQL = "delete from Client where id = ?";

        jdbcTemplateObject.update(SQL, id);

        System.out.println ("Deleted Record with ID = " + id);

    }

    public void update (Integer id, String name) {

        String SQL = "update Client set name = ? where id = ?";

        jdbcTemplateObject.update (SQL, name, id);

        System.out.println ("Updated Record with ID = " + id);

    }

    public Client selectById (Integer id) {

        String SQL = "select * from Client where id = ?";

        Client client = jdbcTemplateObject.queryForObject (SQL, new Object [] { id }, new ClientMapper ());

        return client;

    }

    public List <Client> selectAll () {

        String SQL = "select * from Client";

        List <Client> clients = jdbcTemplateObject.query (SQL, new ClientMapper ());

        return clients;

    }

}
