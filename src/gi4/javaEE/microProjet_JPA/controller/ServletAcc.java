package gi4.javaEE.microProjet_JPA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletAcc() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("ID");
		if (id.equals("ident") ) {
		request.getRequestDispatcher("identifier.jsp").forward(request, response);
		}
		if (id.equals("inscr") ) {
			request.getRequestDispatcher("inscrire.jsp").forward(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
