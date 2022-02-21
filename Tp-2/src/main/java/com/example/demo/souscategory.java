package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="souscategory")
public class souscategory {
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Id
	private int id;
	@Column(name="nom")//,lenght=30 , nullable=false
	private String nom;
	@Column(name="category")
	private int category;
	@Column(name="souscategory")
	private int souscategory;
	public int getId() {return id;}
	public void setId(int i) {id = i;}
	public String getNom() {return nom;}
	public void setNom(String n) {nom = n;}
	public int getCategory() {return category;}
	public void setCategory(int lacategory) {category = lacategory;}
	public int getSouscategory() {return souscategory;}
	public void setSouscategory(int souscategory) {this.souscategory = souscategory;}
	
}
