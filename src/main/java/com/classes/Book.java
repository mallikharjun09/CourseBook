package com.classes;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.DecimalMin;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Book")
public class Book {
	@Id
	@GeneratedValue
	@Column(name="id")
     private int id;
	
	@Column(name="cost")
	@DecimalMin("1.0")
     private double cost;
	@Column(name="description")
	@Size(min=10,message="Description at least more than 10 Characters")
     private String description;
	@Column(name="author")
	@Size(min=3,message="Author Name must be more than 3 letters")
     private String author;
	@Column(name="name")
	@Size(min=3,message="Name must be more than 3 letters")
     private String name;
	@Column(name="porlang")
	@Size(min=1,message="Subject must contain At least one letter")
     private String proLang;
	@Column(name="image",columnDefinition="varchar(255)")
	@Size(min=3,message="Please Select the Image")
	private	String image;
	@JsonIgnore
	transient private MultipartFile img;
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
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
		
	}
}
