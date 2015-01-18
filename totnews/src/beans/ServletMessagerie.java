package beans;


import java.io.IOException;
import java.util.Collection;
import java.util.Date;

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
		Compte utilisateur = facade.getCompteUtilisateur(request.getUserPrincipal().getName());
		request.setAttribute("droit", utilisateur.getDroit());

		if (op.equals ("accederMessagerie")) {
			request.getRequestDispatcher("/WEB-INF/restricted/messagerie.jsp").forward(request,response);
		} else if (op.equals ("envoiMessage")) {
			String destinataire=request.getParameter("Destinataire");
			String objet=request.getParameter("Objet");
			String contenu=request.getParameter("Contenu");
			Compte compteDestinataire=facade.getCompteUtilisateurPseudoSite(destinataire);
			String erreur;
			if (compteDestinataire==null) {
				erreur="destinataire";
				request.setAttribute("erreur", erreur);
				request.getRequestDispatcher("/WEB-INF/restricted/envoiMessageEchoue.jsp").forward(request, response);
			} else if (objet.isEmpty()) {
				erreur="objet";
				request.setAttribute("erreur", erreur);
				request.getRequestDispatcher("/WEB-INF/restricted/envoiMessageEchoue.jsp").forward(request, response);
			} else {
				Date datePub = new Date();
				facade.ajouterMessage(utilisateur, contenu, compteDestinataire, objet, datePub);
				request.getRequestDispatcher("/WEB-INF/restricted/messagerie.jsp").forward(request,response);
			}
		} else if (op.equals ("lireMessage")) {
			MessagePrive messagePrive = facade.getMessagePrive(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("messagePrive", messagePrive);
			request.getRequestDispatcher("/WEB-INF/restricted/lireMessage.jsp").forward(request,response);		
		} else if (op.equals ("ecrireMessage")) {
			request.getRequestDispatcher("/WEB-INF/restricted/ecrireMessage.jsp").forward(request, response);
		} else if (op.equals ("messagesRecus")) {
			Collection <MessagePrive> mpRecus=facade.getMessagesPrivesRecus(utilisateur);
			request.setAttribute("mpRecus", mpRecus);
			request.getRequestDispatcher("/WEB-INF/restricted/messagesRecus.jsp").forward(request, response);
		}else if (op.equals ("messagesEnvoyes")) {
			Collection <MessagePrive> mpEnvoyes=facade.getMessagesPrivesEnvoyes(utilisateur);
			request.setAttribute("mpEnvoyes", mpEnvoyes);
			request.getRequestDispatcher("/WEB-INF/restricted/messagesEnvoyes.jsp").forward(request, response);
		}
	}
}