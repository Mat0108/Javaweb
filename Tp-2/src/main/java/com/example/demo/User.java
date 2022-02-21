package com.example.demo;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User implements Serializable , UserDetails {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 @Column(name="nom")
	 private String nom;
	 @Column(name="password")
	 private String password;
	 public Integer getUserId() {
		 return id;
	 }
	 public void setUserId(Integer userId) {
		 this.id = userId;
	 }
	 public String getUsername() {
		 return nom;
	 }
	 
	 @Override
	 public boolean isAccountNonExpired() {
		 return false;
	 }
	 @Override
 	 public boolean isAccountNonLocked() {
		 return false;
	 }
	 @Override
	 public boolean isCredentialsNonExpired() {
		 return false;
	 }
	 @Override
	 public boolean isEnabled() {
		 return false;
	 }
	 public void setUsername(String username) {
		 this.nom = username;
	 }
	 @Override
	 public Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
		 return null;
	 }
	 public String getPassword() {
		 return password;
	 }
	 public void setPassword(String password) {
		 this.password = password;
	 } 
}
