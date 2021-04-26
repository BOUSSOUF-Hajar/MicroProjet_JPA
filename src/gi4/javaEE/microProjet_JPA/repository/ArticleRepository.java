package gi4.javaEE.microProjet_JPA.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import gi4.javaEE.microProjet_JPA.entity.Article;

public class ArticleRepository {

	private EntityManager entityManager;

	public ArticleRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Optional<Article> findById(Integer id){
		Article article = entityManager.find(Article.class, id);
		return article != null ? Optional.of(article) : Optional.empty();
	}
	
	public List<Article> findAll() {
		return entityManager.createQuery("from Article").getResultList();
	}
	
	public Optional<Article> save(Article article) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(article);
			entityManager.getTransaction().commit();
			
			return Optional.of(article);
		} catch(Exception e) {
			  e.printStackTrace();
		}
		return Optional.empty();
	}
}
