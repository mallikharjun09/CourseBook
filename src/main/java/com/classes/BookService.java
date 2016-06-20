package com.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookService {

	@Autowired
	BookDao bookDao;
	
	public int addBook(Book book){
		return bookDao.addBook(book);
	}
	public List getAllBooks(){
		return bookDao.getAllBooks();
	}
	public Book getSingleBook(int id){
		return bookDao.getSingleBook(id);
	}
	public int updateBook(int id){
		return bookDao.updateBook(id);
	}
	public int deleteBook(int id){
		return bookDao.deleteBook(id);
	}
}
