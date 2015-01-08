package beans;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.comptes.Compte;
import beans.droits.Droit;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletArticles")
public class ServletArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	Facade facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletArticles() {
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
		String op=request.getParameter("op");
		String user="olienhar";
		Compte compteUtilisateur=facade.getCompteUtilisateur(user);

		if (compteUtilisateur==null) {
			facade.ajouterCompte(user);
			compteUtilisateur=facade.getCompteUtilisateur(user);
		}
		
		if (op.equals ("listerArticles")) {
			facade.setDroitUtilisateur(Droit.CORRECTEUR, compteUtilisateur);
			request.setAttribute("droit", compteUtilisateur.getDroit());
			request.getRequestDispatcher("listeArticles.jsp").forward(request,response);
		} else if (op.equals ("redigerArticle")) {
			request.getRequestDispatcher("redigerArticle.jsp").forward(request,response);
		} else if (op.equals ("soumissionArticle")) {
			request.getRequestDispatcher("index.jsp").forward(request,response);
		} else if (op.equals ("lireArticle")) {
			request.getRequestDispatcher("lireArticle.jsp").forward(request,response);
		} else if (op.equals ("posterCommentaire")) {
			request.getRequestDispatcher("lireArticle.jsp").forward(request,response);
		} else if (op.equals ("PublierArticle")) {
			request.getRequestDispatcher("publierArticle.jsp").forward(request,response);
		} else if (op.equals ("CorrigerArticle")) {
			request.getRequestDispatcher("corrigerArticle.jsp").forward(request,response);
		}
	}

}