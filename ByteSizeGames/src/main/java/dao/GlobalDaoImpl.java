package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Global;
import util.HibernateUtil;

public class GlobalDaoImpl implements GlobalDao{

	@Override
	public Global getGlobalStats() {
		Session s = HibernateUtil.getSession();
		Global g = s.get(Global.class, 1);
		return g;
	}

	@Override
	public void updateGlobalStats(Global g) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(g);
		tx.commit();
		s.close();	
	}

}
