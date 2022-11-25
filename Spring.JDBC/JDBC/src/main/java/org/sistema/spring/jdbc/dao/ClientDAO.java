package org.sistema.spring.jdbc.dao;

import java.util.List;
import javax.sql.DataSource;
import org.sistema.spring.jdbc.models.Client;

/**
 * DAO class for Client entity
 *
 * @author Eugenia Pérez Martínez
 * @email eugenia_perez@cuatrovientos.org
 */

public interface ClientDAO {

    /**
     * This is the method to be used to initialize database resources ie.
     * connection.
     */
    public void setDataSource (DataSource ds);

    /**
     * This is the method to be used to create a record in the Client table.
     */
    public void insert (String name, String country, String phone, Integer age);

    /**
     * This is the method to be used to list down a record from the Client
     * table corresponding to a passed client id.
     */
    public Client selectById (Integer id);

    /**
     * This is the method to be used to list down all the records from the
     * Client table.
     */
    public List <Client> selectAll ();

    /**
     * This is the method to be used to delete a record from the Client table
     * corresponding to a passed client id.
     */
    public void delete (Integer id);

    /**
     * This is the method to be used to update a record into the Client table.
     */
    public void update (Integer id, String name);

}
