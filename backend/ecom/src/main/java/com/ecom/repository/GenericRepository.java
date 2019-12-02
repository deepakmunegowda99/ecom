package com.ecom.repository;

import java.util.List;

public interface GenericRepository<T> {
	   T findOne(long id);
	 
	   List<T> findAll();
	 
	   void create(T entity);
	 
	   T update(T entity);
	 
	   void delete(T entity);
	 
	   void deleteById(long entityId);
}
