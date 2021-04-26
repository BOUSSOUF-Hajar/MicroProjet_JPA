package gi4.javaEE.microProjet_JPA.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gi4.javaEE.microProjet_JPA.entity.Client;


public class ServletIdentification extends HttpServlet {
	private EntityManagerFactory entityManagerFactory = null;
	  private EntityManager entityManager = null ;
	private static final long serialVersionUID = 1L;
       
    
    public ServletIdentification() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		request.getRequestDispatcher("identifier.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resultat ;
		 
		Map<String,String > erreurs= new HashMap<String, String>();
		String email = request.getParameter("email");
		String motdepasse = request.getParameter("mdp");
		
		
		
		 try {
	            validationEmail(email);
	            
	        } catch (Exception e) {
	                /* Gérer les erreurs de validation ici. */
	        	  erreurs.put("email" , e.getMessage() ) ;
	        }		 
		 try {
	            validationUser(email,motdepasse );
	            
	        } catch (Exception e) {
	            /* Gérer les erreurs de validation ici. */
	        	  erreurs.put( "user", e.getMessage() );
	        }
		
		 if ( !erreurs.isEmpty() ) { 
		 request.setAttribute( "erreurs", erreurs );
	     this.getServletContext().getRequestDispatcher("/identifier.jsp").forward( request, response );
		 }
		 else {
			 this.getServletContext().getRequestDispatcher("/Servlet1").forward( request, response );
			 
		 }
	}
	void validationEmail( String email ) throws Exception {
	    if ( email != null && email.trim().length() != 0 ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}
	void validationUser(String email,String motdepasse) throws Exception{
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("GI4");
			entityManager = entityManagerFactory.createEntityManager();
		Query q=entityManager.createQuery("SELECT nom,prenom FROM client WHERE email='"+email+"' and mdp='"+motdepasse+"'");
		if(q==null) {
			
		}
		else {
			throw new Exception( "vous n'étes pas inscrit !!" );
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
