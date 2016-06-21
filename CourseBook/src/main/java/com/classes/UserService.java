package com.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public void addUser(User user){
		userDao.addUser(user);
	}
	public List getAllUsers(){
		return userDao.getAllUsers();
	}
	public User getSingleUser(int id){
		return userDao.getSingleUser(id);
	}
	public int updateUser(int id){
		return userDao.updateUser(id);
	}
	public int deleteUser(int id){
		return userDao.deleteUser(id);
	}
}
