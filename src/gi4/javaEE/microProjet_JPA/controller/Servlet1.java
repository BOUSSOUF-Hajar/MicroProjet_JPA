package gi4.javaEE.microProjet_JPA.controller;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  gi4.javaEE.microProjet_JPA.entity.Client;



public class Servlet1 extends HttpServlet {
	private Connection connection=null;
	private Statement stmt=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom=request.getParameter("nom");
		String mdp=request.getParameter("mdp");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String addr=request.getParameter("addr");
		Client clt=null;
				
			if(email!=null & mdp!=null) {
					
					  EntityManagerFactory entityManagerFactory = null;
					  EntityManager entityManager = null ;
					  try {
						   entityManagerFactory = Persistence.createEntityManagerFactory("GI4");
						   entityManager = entityManagerFactory.createEntityManager();
						   Query q=entityManager.createQuery("SELECT nom,prenom FROM client WHERE email='"+email+"' and mdp='"+mdp+"'");
						   if(q==null) {
							   entityManager.createNativeQuery("INSERT INTO client(nom,prenom,email,addr,mdp) VALUES (?,?,?,?,?)")
							      .setParameter(1,nom)
							      .setParameter(2, prenom)
							      .setParameter(3,email)
							      .setParameter(4,addr)
							      .setParameter(5,mdp)
							      .executeUpdate();
						   }
						   Query q1=entityManager.createQuery("SELECT nom,prenom FROM client WHERE email='"+email+"' and mdp='"+mdp+"'");
						   
						   clt=(Client) q1.getSingleResult();
					  }
					  catch(Exception e) {
						  e.printStackTrace();
					  }
		
			
		}
			request.setAttribute("user", clt);
			request.getRequestDispatcher("accueil1.jsp").forward(request, response);
			
			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
