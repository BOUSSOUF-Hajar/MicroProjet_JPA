package gi4.javaEE.microProjet_JPA.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import gi4.javaEE.microProjet_JPA.entity.Client;

public class ClientRepository {
	
	private static   EntityManager entityManager;

	public ClientRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Optional<Client> findById(Integer id){
		Client clt = entityManager.find(Client.class, id);
		return clt != null ? Optional.of(clt) : Optional.empty();
	}
	
   public List<Client> findAll() {
	   return entityManager.createQuery("from Client").getResultList();
   }
   
   public Optional<Client> fiendByFirstName(String nom){
	   Client clt = entityManager.createQuery("SELECT c from Client c WHERE c.nom = :nom ", Client.class).setParameter("nom", nom).getSingleResult();
	   return clt != null ? Optional.of(clt) : Optional.empty();
			   
   }
   
   public static  Optional<Client> save(Client clt){
	   try {
		   entityManager.getTransaction().begin();
		   entityManager.persist(clt);
		   entityManager.getTransaction().commit();
		   return Optional.of(clt);
		  
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   return Optional.empty();
   }
}
