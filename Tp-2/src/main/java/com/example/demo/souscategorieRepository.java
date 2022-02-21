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
public interface souscategorieRepository extends CrudRepository<souscategory , Long> {
	
	@Query("SELECT s FROM souscategory s WHERE s.category =  ?1 ")
	Iterable<souscategory> findbySousCategorie(Integer cateogorie);
	@Query("SELECT s FROM souscategory s WHERE s.id =  ?1 ")
	souscategory findbyId(Integer id);
	@Query("SELECT s FROM souscategory s WHERE s.nom =  ?1 ")
	souscategory findbyName(String nm);
	
}
