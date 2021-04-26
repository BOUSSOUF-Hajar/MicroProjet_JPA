package gi4.javaEE.microProjet_JPA.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class catalogueList {
	EntityManagerFactory entityManagerFactory = null;
	  EntityManager entityManager = null ;
	
	public List<Article> list() throws SQLException {
        
        try {
			   entityManagerFactory = Persistence.createEntityManagerFactory("GI4");
			   entityManager = entityManagerFactory.createEntityManager();
			   Query q=entityManager.createQuery("SELECT * FROM article ORDER BY categorie");
			   @SuppressWarnings("unchecked")
			   List<Article> listgenre= (List<Article>) q.getResultList();
			   return listgenre;
			  
             
        } catch (Exception e) {
            e.printStackTrace();
        }
           
        
         return null;
        
    }
}


