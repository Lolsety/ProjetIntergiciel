package beans;


import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.comptes.Compte;
import beans.droits.Droit;
import beans.texte.Article;

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
		if (request.getUserPrincipal()!=null) {
			Compte utilisateur = facade.getCompteUtilisateur(request.getUserPrincipal().getName());
		    request.setAttribute("droit", utilisateur.getDroit());
		    request.setAttribute("pseudo", utilisateur.getPseudoSite());
		}
		if (op.equals ("listerArticles")) {
			request.setAttribute("listeArticles", facade.getArticles());
			request.getRequestDispatcher("/WEB-INF/listeArticles.jsp").forward(request,response);
		} else if (op.equals ("redigerArticle")) {
			request.getRequestDispatcher("/WEB-INF/restricted/redigerArticle.jsp").forward(request,response);
		} else if (op.equals ("soumissionArticle")) {
			String titre = request.getParameter("Titre");
			String corps = request.getParameter("CorpsArticle");
			Date date = new Date();
			facade.ajouterArticle(request.getUserPrincipal().getName(), titre, corps, date);
			request.getRequestDispatcher("/WEB-INF/restricted/index.jsp").forward(request,response);
		} else if (op.equals ("lireArticle")) {
			Article a = facade.getArticle(request.getParameter("id"));
			a.setText(a.getURL() + Integer.toString(a.getId()) + ".txt");
			request.setAttribute("id", id);
			request.setAttribute("article", a);
			request.getRequestDispatcher("/WEB-INF/lireArticle.jsp").forward(request,response);
		} else if (op.equals ("posterCommentaire")) {
			Article a = facade.getArticle(request.getParameter("id"));
			String texte = request.getParameter("Commentaire");
			Date date = new Date();
			façade.ajouterCommentaire(request.getUserPrincipal().getName(), article, texte, date);
			request.getRequestDispatcher("/WEB-INF/lireArticle.jsp").forward(request,response);
		} else if (op.equals ("PublierArticle")) {
			request.setAttribute("publier", facade.publierArticle(request.getParameter("id")));
			request.getRequestDispatcher("/WEB-INF/restricted/publierArticle.jsp").forward(request,response);
		} else if (op.equals ("CorrigerArticle")) {
			Article a = facade.getArticle(request.getParameter("id"));
			a.setText(a.getURL() + Integer.toString(a.getId()) + ".txt");
			request.setAttribute("article", a);
			request.getRequestDispatcher("/WEB-INF/restricted/corrigerArticle.jsp").forward(request,response);
		} else if (op.equals ("CorrectionArticle")) {
			String titre = request.getParameter("Titre");
			String corps = request.getParameter("CorpsArticle");
			Date date = new Date();
			facade.modifierArticle(request.getParameter("id"), request.getUserPrincipal().getName(), titre, corps, date);
			request.setAttribute("publier", "corrig�");
			request.getRequestDispatcher("/WEB-INF/restricted/publierArticle.jsp").forward(request,response);
		}
	}

}