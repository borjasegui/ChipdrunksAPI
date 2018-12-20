package com.squirrelTail.persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClanManager {

	private static ClanManager instancia = null;
	private static SessionFactory sf = null;

	public static ClanManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new ClanManager();

		return instancia;
	}

	private ClanManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
}
