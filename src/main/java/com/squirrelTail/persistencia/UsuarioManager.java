package com.squirrelTail.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.squirrelTail.models.Usuario;

public class UsuarioManager {

	private static UsuarioManager instancia = null;
	private static SessionFactory sf = null;

	public static UsuarioManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new UsuarioManager();

		return instancia;
	}

	private UsuarioManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public int createUsuario(Usuario newE) throws Exception {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		int id = ((Integer) session.save(newE)).intValue();

		t.commit();
		session.close();

		return id;
	}

	public Usuario getUsuario(int id) throws Exception {
		Session session = sf.openSession();

		Usuario recE = session.get(Usuario.class, id);

		session.close();

		return recE;
	}

}