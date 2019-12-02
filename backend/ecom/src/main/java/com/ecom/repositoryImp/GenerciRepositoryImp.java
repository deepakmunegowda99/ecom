package com.ecom.repositoryImp;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ecom.repository.GenericRepository;

public abstract class GenerciRepositoryImp< T extends Serializable > 
implements GenericRepository<T> {
	
private Class< T > clazz;
	 
	   @PersistenceContext
	   EntityManager entityManager;
	 
	   public void setClazz( Class< T > clazzToSet ) {
	      this.clazz = clazzToSet;
	   }
	 
	   public T findOne( Long id ){
	      return entityManager.find( clazz, id );
	   }
	   public List< T > findAll(){
	      return entityManager.createQuery( "from " + clazz.getName() )
	       .getResultList();
	   }
	 
	   public void save( T entity ){
	      entityManager.persist( entity );
	   }
	 
	   public T update( T entity ){
	      return entityManager.merge( entity );
	   }
	 
	   public void delete( T entity ){
	      entityManager.remove( entity );
	   }
	   public void deleteById( Long entityId ){
	      T entity = findOne( entityId );
	      delete( entity );
	   }

}