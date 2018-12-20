package com.squirrelTail.persistencia;

import java.util.List;

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

	public Usuario createUsuario(Usuario newE) throws Exception {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		int nid = ((Integer) session.save(newE)).intValue();
		newE.setNid(nid);
		
		t.commit();
		session.close();

		return newE;
	}

	public Usuario getUsuario(int id) throws Exception {
		Session session = sf.openSession();

		Usuario recE = session.get(Usuario.class, id);

		session.close();

		return recE;
	}

	public List<Usuario> getUsuarios() {
		Session sess = sf.openSession();

		List<Usuario> listaUsuarios = sess.createQuery("from Usuario").list();

		sess.close();
		
		return listaUsuarios;
	}

}