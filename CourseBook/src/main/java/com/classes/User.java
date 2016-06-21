package com.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	 @Id
	 @GeneratedValue
	 @Column(name="id")
     private int id;
	 @Column(name="name")
     private String name;
	 @Column(name="mail")
     private String mail;
	 @Column(name="phone")
     private long phone;
	 @Column(name="password")
     private String password;
	 @Column(name="role",columnDefinition="varchar(6) default 'User'")
     private String role;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
