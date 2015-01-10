package com.login;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.comptes.Compte;
import beans.droits.Droit;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	beans.Facade facade;
	
	public LoginServlet() {
		super();
	}
    
   /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request,response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
	    	Compte compte = facade.getCompteUtilisateur(request.getUserPrincipal().getName());
	    	if (request.isUserInRole("admin")) {
	    		compte.setDroit(Droit.ADMNINISTRATEUR);
	    	}
    	    request.setAttribute("droit", compte.getDroit());
    	    request.getRequestDispatcher("/WEB-INF/restricted/index.jsp").forward(request, response);
    	} catch (Exception e) {
    		request.getSession().invalidate();
    		request.getRequestDispatcher("/index.html").forward(request, response);
    	}
    }
}
