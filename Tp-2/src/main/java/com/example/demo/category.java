package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="category")
public class category {	
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Id
	private int id;
	@Column(name="nom")//,lenght=30 , nullable=false
	private String nom;
	//
	public int getId() {return id;}
	public void setId(int i) {id = i;}
	public String getNom() {return nom;}
	public void setNom(String n) {nom = n;}
}
