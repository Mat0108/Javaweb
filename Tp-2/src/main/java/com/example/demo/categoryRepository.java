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
public interface categoryRepository extends CrudRepository<category , Long> {
	
	@Query("SELECT c FROM category c WHERE c.nom = ?1 ")
	category findByNom(String nm); 
	@Query("SELECT c FROM category c WHERE c.id = ?1 ")
	category findbyid2(Integer id); 
	
}
