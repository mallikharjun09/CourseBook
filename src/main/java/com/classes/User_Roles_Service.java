package com.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class User_Roles_Service {

	@Autowired
	User_Roles_Dao userDao;
	
	public void addUser_Roles_(User_Roles user){
		userDao.addUser_Roles(user);
	}
	public List getAllUser_Roles_s(){
		return userDao.getAllUser_Roles();
	}
	public User_Roles getSingleUser_Roles(int id){
		return userDao.getSingleUser_Roles(id);
	}
	public int updateUser_Roles_(int id){
		return userDao.updateUser_Roles(id);
	}
	public int deleteUser_Roles_(int id){
		return userDao.deleteUser_Roles(id);
	}
}
