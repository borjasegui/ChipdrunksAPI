package com.squirrelTail.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.squirrelTail.models.Clan;

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

	public List<Clan> getClanes() {
		Session sess = sf.openSession();

		List<Clan> listaClanes = sess.createQuery("from Clan").list();

		sess.close();
		
		return listaClanes;
	}
	
	public Clan createClan(Clan newE) throws Exception {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		int nid = ((Integer) session.save(newE)).intValue();
		newE.setCid(nid);
		
		t.commit();
		session.close();

		return newE;
	}

	public Clan getClan(int cid) throws Exception {
		Session session = sf.openSession();

		Clan recE = session.get(Clan.class, cid);

		session.close();

		return recE;
	}
}
