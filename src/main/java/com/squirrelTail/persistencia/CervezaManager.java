package com.squirrelTail.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squirrelTail.models.Cerveza;
import com.squirrelTail.models.Usuario;

public class CervezaManager {
	private static CervezaManager instancia = null;
	private static SessionFactory sf = null;

	public static CervezaManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new CervezaManager();

		return instancia;
	}

	private CervezaManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public List<Cerveza> getCervezas() {
		Session sess = sf.openSession();

		List<Cerveza> listaCerveza = sess.createQuery("from Cerveza").list();

		sess.close();
		
		return listaCerveza;
	}
	
	public Cerveza getCerveza(int zid) throws Exception {
		Session session = sf.openSession();

		Cerveza recC = session.get(Cerveza.class, zid);

		session.close();

		return recC;
	}
	
}
