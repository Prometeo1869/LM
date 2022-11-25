package org.sistema.spring.jdbc;

import java.util.List;
import org.sistema.spring.jdbc.dao.impl.JdbcClientDAO;
import org.sistema.spring.jdbc.models.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class.
 *
 * @author Eugenia Pérez Martínez
 * @email eugenia_perez@cuatrovientos.org
 */

public class Main {

	public static void main (String [] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext ("beans.xml");

		JdbcClientDAO clientDAO = (JdbcClientDAO) context.getBean ("clientJDBCTemplate");

		System.out.println ("Creating clients .....................");

//		clientDAO.insert ("César", "Spain", "676123456", 32);
//		clientDAO.insert ("John", "UK", "098765433", 45);
//		clientDAO.insert ("Mauro", "Italy", "11223344", 15);
//		clientDAO.insert ("Eugenia", "Spain", "985123456", 30);

		System.out.println ();

		selectAllClients (clientDAO);

		System.out.println ("Updating Client with ID = 3 ............");

		clientDAO.update (3, "Peter");

		System.out.println ();

		System.out.println ("Listing Client with ID = 3 .............");

		Client client = clientDAO.selectById (3);

		System.out.print ("ID : " + client.getId ());

		System.out.println (", Name : " + client.getName ());

		System.out.println ();

		System.out.println ("Deleting Client with ID=1 ...............");

		clientDAO.delete (1);

		selectAllClients (clientDAO);

	}

	private static void selectAllClients (JdbcClientDAO clientDAO) {

		System.out.println ("Listing clients .......................");

		List <Client> clients = clientDAO.selectAll ();

		for (Client record : clients) {

			System.out.print ("ID : " + record.getId ());
			System.out.print (", Name : " + record.getName ());
			System.out.print (", Country : " + record.getCountry ());
			System.out.print (", Phone : " + record.getPhone ());
			System.out.println (", Age : " + record.getAge ());

		}

		System.out.println ();

	}

}
