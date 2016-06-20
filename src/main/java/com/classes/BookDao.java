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
public class BookDao {
	@Autowired
    private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Transactional
	public int addBook(Book book){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(book);
		tx.commit();
		Serializable id=session.getIdentifier(book);
		session.close();
		return (Integer)id;
	}
	public List getAllBooks(){
		Session session=sf.openSession();
		List blist=session.createQuery("from Book").list();
		session.close();
		return blist;
	}
	
	public Book getSingleBook(int id){
		Session session=sf.openSession();
		Book book=(Book)session.load(Book.class, id);
		return book;
	}
	
	public int deleteBook(int id){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Book book=(Book)session.load(Book.class, id);
		session.delete(book);
		tx.commit();
		Serializable ids=session.getIdentifier(book);
		session.close();
		return (Integer)ids;
	}
	
	
	public int updateBook(int id){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Book book=(Book)session.load(Book.class, id);
		session.saveOrUpdate(book);
		tx.commit();
		Serializable ids=session.getIdentifier(book);
		session.close();
		return (Integer)ids;
		
	}
}
