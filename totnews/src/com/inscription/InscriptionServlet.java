package com.inscription;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.CompteDejaCree;
import exception.PseudoDejaUtilise;
import beans.droits.Droit;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	beans.Facade facade;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pseudoLDAP = request.getParameter("PseudoLDAP");
		String pseudoSite = request.getParameter("PseudoSite");
		String email = request.getParameter("eMail");
		if (email.isEmpty()) {
			email = "non renseigné";
		}
		String nom = request.getParameter("nom");
		if (nom.isEmpty()) {
			nom = "non renseigné";
		}
		String prenom = request.getParameter("prenom");
		if (prenom.isEmpty()) {
			prenom = "non renseigné";
		}
		String age = request.getParameter("age");
		Droit droit = Droit.UTILISATEUR;
		try {			
			facade.ajouterCompte(pseudoLDAP,pseudoSite,email,nom,prenom,age,droit);
			response.sendRedirect("/journal/index.html");
		} catch (CompteDejaCree e) {
			// TODO
			request.setAttribute("pseudoLDAPErreur", "Ce login ldap est déjà affilié à un compte.");
			request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		} catch (PseudoDejaUtilise e) {
			// TODO Auto-generated catch block
			request.setAttribute("pseudoSiteErreur", "Ce pseudonyme est déjà utilisé.");
			request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		}
	}

}
