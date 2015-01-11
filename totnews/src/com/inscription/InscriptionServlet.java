package com.inscription;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.CompteDejaCree;
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
		if (email==null) {
			email = "non renseigné";
		}
		String nom = request.getParameter("nom");
		if (nom==null) {
			nom = "non renseigné";
		}
		String prenom = request.getParameter("prenom");
		if (prenom==null) {
			prenom = "non renseigné";
		}
		String age = request.getParameter("age");
		Droit droit = Droit.UTILISATEUR;
		try {
			facade.ajouterCompte(pseudoLDAP,pseudoSite,email,nom,prenom,age,droit);
		} catch (CompteDejaCree e) {
			// TODO
		}
		response.sendRedirect("/journal/index.html");
	}

}
