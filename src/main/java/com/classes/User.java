package com.classes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="User")
public class User {
	 @Id
	 @GeneratedValue
	 @Column(name="uid")
     private int uid;
	 @Column(name="Enabled")
	private
	 boolean enabled;
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
	 @Min(message="Phone Number Should Contain 10 digits", value = 10)
     private long phone;
	 @Column(name="Status")
	 private String status;
	 @Column(name="password")
	 @Size(min=5,message="Password must be more than 5 letters")
     private String password;
	 
	 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int id) {
		this.uid = uid;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
