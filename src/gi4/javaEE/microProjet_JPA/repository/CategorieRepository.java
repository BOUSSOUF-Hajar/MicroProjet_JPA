package gi4.javaEE.microProjet_JPA.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import gi4.javaEE.microProjet_JPA.entity.Categorie;

public class CategorieRepository {
	
		private EntityManager em;
		
		public CategorieRepository(EntityManager em) {
			
			this.em = em;
		}
		
		public Optional<Categorie> findById(Integer id) {
			Categorie cat = em.find(Categorie.class, id);
			return cat != null ? Optional.of(cat) : Optional.empty();
		}

		public Optional<Categorie> save(Categorie cat) {
			try {
				em.getTransaction().begin();
				em.persist(cat);
				em.getTransaction().commit();
				return Optional.of(cat);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return Optional.empty();
		}
}
