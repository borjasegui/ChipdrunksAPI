package com.squirrelTail.ManagerTest;



import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.junit.BeforeClass;
import org.junit.Test;

import com.squirrelTail.models.Usuario;

public class UsuarioTest {

	private static SessionFactory sf = null;
	Session session = null;

	@BeforeClass
	public static void createSessionFactory() {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	@Test
	public void testSession() {
		session = sf.openSession();
		assertNotNull(session);
	}

	@Test
	public void ListadoRanking() {
		List<Usuario> usuarios;
		try {
			Criteria c = session.createCriteria(Usuario.class);
			c.createAlias("Usuario", "u");
			c.addOrder(Order.asc("u"));
			usuarios = c.list();
			for (Usuario usuario : usuarios) {
				System.out.println("hola");
				System.out.println(usuario.getNombre() + " " + usuario.getNºbares());
			}
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
