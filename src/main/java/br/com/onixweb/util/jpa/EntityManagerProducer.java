package br.com.onixweb.util.jpa;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class EntityManagerProducer {

	@PersistenceContext(unitName="OnixPU")
	private EntityManager manager;	
	
	@Produces 
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.manager;
	}
	
}