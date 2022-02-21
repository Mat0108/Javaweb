package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/*
* Classe de methode pour les repository issues de la classe mère
long count()
void delete(T entity)
void deleteAll()
void deleteAll(Iterable<? extends T> entities)
void deleteById(ID id)
boolean existsById(ID id)
Iterable<T> findAll()
Iterable<T> findAllById(Iterable<ID> ids)
Optional<T> findById(ID id)
<S extends T>S save(S entity)
<S extends T>Iterable<S> saveAll(Iterable<S> entities)
*/
//CRUD (Create, Read, Update, Delete)
public interface produitsRepository extends CrudRepository<produits , Long> {
	@Query("SELECT p FROM produits p WHERE p.category =  ?1 AND p.souscategory = ?2 ")
	Iterable<produits> findbyCategory(Integer category,Integer souscategory);

	@Query("SELECT p FROM produits p WHERE p.id =  ?1 ")
	produits findbyId2(Integer nm);
	@Query("SELECT p FROM produits p WHERE p.nom =  ?1 ")
	produits findbyName(String nm);
}
