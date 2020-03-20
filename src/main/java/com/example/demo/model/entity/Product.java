package com.example.demo.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PRODUCTS")
@Getter
@Setter
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	long id;

	@Column(name = "title")
	String title;

	@Column(name = "description")
	String description;

	@Column(name = "price")
	Double price;

	@Column(name = "imageURL")
	String imageURL;

	@Column(name = "views")
	long numberofViews;

}
