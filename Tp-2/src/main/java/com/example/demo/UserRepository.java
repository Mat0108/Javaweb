package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	 //requête de l’utilisateur (nom et password) en fonction du nom
	 @Query(" select u from User u where u.nom = ?1")
	 User findUserWithName(String username);
}