package com.example.demo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produits")
public class produits {
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Id
	private int id;
	@Column(name="nom")//,lenght=30 , nullable=false
	private String nom;
	@Column(name="stock")
	private String stock;
	@Column(name="discription")
	private String discription;
	@Column(name="category")
	private int category;
	@Column(name="souscategory")
	private int souscategory;
	public int getId() {return id;}
	public void setId(int i) {id = i;}
	public String getNom() {return nom;}
	public void setNom(String n) {nom = n;}
	public String getStock() {return stock;}
	public void setStock(String stock) {this.stock = stock;}
	public String getDiscription() {return discription;}
	public void setDiscription(String discription) {this.discription = discription;}
	public int getCategory() {return category;}
	public void setCategory(int lacategory) {category = lacategory;}
	public int getSousCategory() {return souscategory;}
	public void setSousCategory(int sousCategory) {souscategory = sousCategory;}
	

}

