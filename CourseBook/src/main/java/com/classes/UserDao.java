package com.classes;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {
	@Autowired
     private SessionFactory sf;
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Transactional
	public int addUser(User user){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		Serializable id=session.getIdentifier(user);
		session.close();
		return (Integer)id;
	}
	public List getAllUsers(){
		Session session=sf.openSession();
		List blist=session.createQuery("from User").list();
		session.close();
		return blist;
	}
	
	public User getSingleUser(int id){
		Session session=sf.openSession();
		User User=(User)session.load(User.class, id);
		return User;
	}
	
	public int deleteUser(int id){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		User user=(User)session.load(User.class, id);
		session.delete(user);
		tx.commit();
		Serializable ids=session.getIdentifier(user);
		session.close();
		return (Integer)ids;
	}
	
	
	public int updateUser(int id){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		User user=(User)session.load(User.class, id);
		session.saveOrUpdate(user);
		tx.commit();
		Serializable ids=session.getIdentifier(user);
		session.close();
		return (Integer)ids;
		
	}
}
