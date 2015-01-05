package openJournal;


import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	Façade façade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
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
		
		if(op.equals("connection")) {
			// on verifie que le  compte existe bien
			boolean connectionReussie=true;
			if (connectionReussie) {
				request.getRequestDispatcher("index.jsp").forward(request,response);
			} else {
				request.getRequestDispatcher("connectionEchouee.html").forward(request,response);
			}
		} else if (op.equals("inscription")){
			// on verifie que le compte ldap existe bien, et on ajoute les informations d'utilisateurs dans notre
			// BD
			boolean inscriptionReussie=true;
			if (inscriptionReussie) {
				request.getRequestDispatcher("index.html").forward(request,response);
			} else {
				request.getRequestDispatcher("inscriptionEchouee.html").forward(request,response);
			}
		}  else if (op.equals("RetourIndex")) {
			request.getRequestDispatcher("index.jsp").forward(request,response);
		} else if (op.equals ("listerArticles")) {
			request.getRequestDispatcher("listeArticles.jsp").forward(request,response);
		} else if (op.equals ("redigerArticle")) {
			request.getRequestDispatcher("redigerArticle.jsp").forward(request,response);
		} else if (op.equals ("accederMessagerie")) {
			request.getRequestDispatcher("messagerie.jsp").forward(request,response);
		} else if (op.equals ("soumissionArticle")) {
			request.getRequestDispatcher("index.jsp").forward(request,response);
		} else if (op.equals ("lireArticle")) {
			request.getRequestDispatcher("lireArticle.jsp").forward(request,response);
		} else if (op.equals ("posterCommentaire")) {
			request.getRequestDispatcher("lireArticle.jsp").forward(request,response);
		} else if (op.equals ("envoiMessage")) {
			request.getRequestDispatcher("messagerie.jsp").forward(request,response);
		} else if (op.equals ("lireMessage")) {
			request.getRequestDispatcher("lireMessage.jsp").forward(request,response);		}
	}

}
