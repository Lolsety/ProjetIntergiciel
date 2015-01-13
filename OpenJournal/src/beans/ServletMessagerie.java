package beans;


import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.comptes.Compte;
import beans.texte.MessagePrive;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletMessagerie")
public class ServletMessagerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	Facade facade;
	
	@EJB
	FacadeMessagerie facadeMessagerie;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMessagerie() {
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
		Compte olivier=facade.getCompteUtilisateur("olienhar");
		Compte anthony=facade.getCompteUtilisateur("amarco");


		if (olivier==null) {
			facade.ajouterCompte("olienhar");
			olivier=facade.getCompteUtilisateur("olienhar");
		}
		
		if (anthony==null) {
			facade.ajouterCompte("amarco");
			anthony=facade.getCompteUtilisateur("amarco");
		}
		
		if (op.equals ("accederMessagerie")) {
			request.getRequestDispatcher("messagerie.jsp").forward(request,response);
		} else if (op.equals ("envoiMessage")) {
			String destinataire=request.getParameter("Destinataire");
			String objet=request.getParameter("Objet");
			String contenu=request.getParameter("Contenu");
			//Compte compteDestinataire=facade.getCompteUtilisateur(destinataire);
			//if (compteDestinataire==null) {
			//	compteDestinataire=anthony;
			//}
			Date datePub = new Date();
			facadeMessagerie.ajouterMessage(olivier, contenu, anthony, objet, datePub);
			request.getRequestDispatcher("messagerie.jsp").forward(request,response);
		} else if (op.equals ("lireMessage")) {
			request.getRequestDispatcher("lireMessages.jsp").forward(request,response);		
		} else if (op.equals ("ecrireMessage")) {
			request.getRequestDispatcher("ecrireMessage.jsp").forward(request, response);
		} else if (op.equals ("messagesRecus")) {
			Collection <MessagePrive> mpRecus=facadeMessagerie.getMessagesPrivesRecus(anthony);
			request.setAttribute("mpRecus", mpRecus);
			request.getRequestDispatcher("messagesRecus.jsp").forward(request, response);
		}else if (op.equals ("messagesEnvoyes")) {
			Collection <MessagePrive> mpEnvoyes=facadeMessagerie.getMessagesPrivesEnvoyes(olivier);
			request.setAttribute("mpEnvoyes", mpEnvoyes);
			request.getRequestDispatcher("messagesEnvoyes.jsp").forward(request, response);
		}
	}
}