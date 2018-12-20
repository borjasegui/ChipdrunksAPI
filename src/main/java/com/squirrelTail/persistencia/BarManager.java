package com.squirrelTail.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squirrelTail.models.Bar;

public class BarManager {
	private static final long serialVersionUID = 1L;

	private static BarManager instancia = null;
	private static SessionFactory sf = null;

	public static BarManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new BarManager();

		return instancia;
	}

	private BarManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public List<Bar> dameTodosLosBares() throws Exception {
		List<Bar> bar = null;

		Session session = sf.openSession();

		bar = (session).createQuery("FROM Bar").list();

		session.close();
		return bar;
	}

	public Bar getBar(int bid) throws Exception {
		Session session = sf.openSession();

		Bar recB = session.get(Bar.class, bid);

		session.close();

		return recB;
	}

	public Bar getBarByBid(int bidInt) {
		////// crear metodoooo x dios
		return null;
	}

}