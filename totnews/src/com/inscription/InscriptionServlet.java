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
		String eMail = request.getParameter("eMail");
		String pseudoSite = request.getParameter("pseudoSite");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String age = request.getParameter("age");
		Droit droit = Droit.UTILISATEUR;
		try {
			facade.ajouterCompte(pseudoLDAP,eMail,pseudoSite,nom,prenom,age,droit);
		} catch (CompteDejaCree e) {
			// TODO
		}
		request.setAttribute("firstConnection",1);
		request.getRequestDispatcher("/LoginServlet").forward(request,response);
	}

}
