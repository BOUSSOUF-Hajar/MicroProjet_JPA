package gi4.javaEE.microProjet_JPA.main;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import gi4.javaEE.microProjet_JPA.entity.Client;
import gi4.javaEE.microProjet_JPA.entity.Commande;
import gi4.javaEE.microProjet_JPA.repository.*;



public class Main {

	
	public static void main(String[] args) {
		
		
		
		  EntityManagerFactory entityManagerFactory = null;
		  EntityManager  entityManager = null ;
		  
		  try {
			  entityManagerFactory = Persistence.createEntityManagerFactory("microProj");
			  entityManager = entityManagerFactory.createEntityManager();  
			   System.out.print("Hi, I'm here");
		  }
			catch(Exception e) {
				e.printStackTrace();
			}
			   // Create our repositories
		    ClientRepository cltRep = new ClientRepository( entityManager);
		    ArticleRepository artRep = new ArticleRepository( entityManager);
		    CommandeRepository cmdRep = new CommandeRepository( entityManager);
		    CategorieRepository catRep = new CategorieRepository( entityManager);
		    
		    Client clt = new Client(1, "BOHOUCH", "Souad", "bohouchsouad@gmail.com", "1111", "addr1",
					"codeP1", "ville1", 9823, null);
		    
		 //   Optional<Client> savedClient = ClientRepository.save(clt);
		   // System.out.println("Saved author: " + savedClient.get());
		  
	}
}
