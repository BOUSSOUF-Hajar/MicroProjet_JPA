package gi4.javaEE.microProjet_JPA.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import gi4.javaEE.microProjet_JPA.entity.Commande;
public class CommandeRepository {
      
	  private EntityManager entityManager;

	public CommandeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	  
	public Optional<Commande> findById(Integer id){
		Commande cmd = entityManager.find(Commande.class, id);
		return cmd != null ? Optional.of(cmd) : Optional.empty();
	}
	public List<Commande> findAll()  {
		return entityManager.createQuery("from Commande").getResultList();
	}
	 
	public Optional<Commande> save(Commande cmd){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(cmd);
			entityManager.getTransaction().commit();
			return Optional.of(cmd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
}
