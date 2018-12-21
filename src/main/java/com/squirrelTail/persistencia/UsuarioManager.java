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

	public List<Usuario> getUsuarios() {
		Session sess = sf.openSession();

		List<Usuario> listaUsuarios = sess.createQuery("from Usuario").list();

		sess.close();
		
		return listaUsuarios;
	}
	
	public Usuario createUsuario(Usuario newU) throws Exception {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		int nid = ((Integer) session.save(newU)).intValue();
		newU.setNid(nid);
		
		t.commit();
		session.close();

		return newU;
	}

	public Usuario getUsuario(int nid) throws Exception {
		Session session = sf.openSession();

		Usuario recU = session.get(Usuario.class, nid);

		session.close();

		return recU;
	}

	public Object updateUsuario(Usuario actU) throws Exception {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		session.update(actU);
		
		t.commit();
		session.close();

		return actU;
	}
}