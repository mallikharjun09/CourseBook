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
public class User_Roles_Dao {
	@Autowired
     private SessionFactory sf;
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Transactional
	public int addUser_Roles(User_Roles user_Roles){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(user_Roles);
		tx.commit();
		Serializable id=session.getIdentifier(user_Roles);
		session.close();
		return (Integer)id;
	}
	public List getAllUser_Roles(){
		Session session=sf.openSession();
		List blist=session.createQuery("from User_Roles").list();
		session.close();
		return blist;
	}
	
	public User_Roles getSingleUser_Roles(int id){
		Session session=sf.openSession();
		User_Roles User_Roles=(User_Roles)session.load(User_Roles.class, id);
		return User_Roles;
	}
	
	public int deleteUser_Roles(int id){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		User_Roles user_Roles=(User_Roles)session.load(User_Roles.class, id);
		session.delete(user_Roles);
		tx.commit();
		Serializable ids=session.getIdentifier(user_Roles);
		session.close();
		return (Integer)ids;
	}
	
	
	public int updateUser_Roles(int id){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		User_Roles user_Roles=(User_Roles)session.load(User_Roles.class, id);
		session.saveOrUpdate(user_Roles);
		tx.commit();
		Serializable ids=session.getIdentifier(user_Roles);
		session.close();
		return (Integer)ids;
		
	}
}
