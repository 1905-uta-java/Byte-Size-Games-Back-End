package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> getUsers() {
		Session s =HibernateUtil.getSession();
		List<User> users = s.createQuery("from User", User.class).list();
		s.close();
		return users;
	}

	@Override
	public User getUserById(int id) {
		Session s = HibernateUtil.getSession();
		User u = s.load(User.class, id); 
		return u;
	}

	@Override
	public int createUser(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = (int) s.save(u);
		tx.commit();
		s.close();
		return pk;
		
		
		
	}

	@Override
	public void updateUser(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(u);
		tx.commit();
		s.close();
		
	}

}
