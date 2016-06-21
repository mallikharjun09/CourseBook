package com.classes;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Book")
public class Book {
	@Id
	@GeneratedValue
	@Column(name="id")
     private int id;
	@Column(name="cost")
     private double cost;
	@Column(name="description")
     private String description;
	@Column(name="author")
     private String author;
	@Column(name="name")
     private String name;
	@Column(name="porlang")
     private String proLang;
	@Column(name="image")
	private	String image;
	//private MultipartFile img;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProLang() {
		return proLang;
	}
	public void setProLang(String proLang) {
		this.proLang = proLang;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	/*public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
		this.image=img.getOriginalFilename();
	}*/
}
