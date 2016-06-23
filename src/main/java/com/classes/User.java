package com.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {
	 @Id
	 @GeneratedValue
	 @Column(name="id")
     private int id;
	 @Column(name="Address")
	 @Size(min=3,message="Address at least more than 3 Characters")
	 private String address;
	 @Column(name="name")
	 @Size(min=3,message="Name Must be more than 2 letters")
     private String name;
	 @Column(name="mail")
	 @Email(message="Please Enter the proper Mail ID")
     private String mail;
	 @Column(name="phone")
	 @Size(min=10,message="Phone Number Should Contain 10 digits")
     private long phone;
	 @Column(name="Enabled")
	 private String enabled;
	 @Column(name="password")
	 @Size(min=5,message="Password must be more than 5 letters")
     private String password;
	 @Column(name="role",columnDefinition="varchar(6) default 'User'")
	 @Size(min=2,message="Role must Contain 2 letters at least")
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
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
}
