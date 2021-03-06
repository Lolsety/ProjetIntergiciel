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
import beans.droits.Utilisateur;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletComptes")
public class ServletComptes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	Facade facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletComptes() {
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
		Compte olivier=facade.getCompteUtilisateur(user);

		if (olivier==null) {
			facade.ajouterCompte(user);
			olivier=facade.getCompteUtilisateur(user);
		}
		
		if(op.equals("connexion")) {
			// on verifiera que le  compte existe bien
			boolean connexionReussie=true;
			if (connexionReussie) {
				request.setAttribute("droit", olivier.getDroit());
				request.getRequestDispatcher("index.jsp").forward(request,response);
			} else {
				request.getRequestDispatcher("connexionEchouee.html").forward(request,response);
			}
		} else if (op.equals("inscription")){
			// on verifiera que le compte ldap existe bien, et on ajoutera les informations d'utilisateurs dans notre
			// BD
			boolean inscriptionReussie=true;
			if (inscriptionReussie) {
				facade.ajouterCompte((String) request.getAttribute("PseudoLDAP"));
				request.getRequestDispatcher("index.html").forward(request,response);
			} else {
				request.getRequestDispatcher("inscriptionEchouee.html").forward(request,response);
			}
		}  else if (op.equals("RetourIndex")) {
			//c'est juste un test
			facade.setDroitUtilisateur(Droit.ADMNINISTRATEUR, olivier);
			request.setAttribute("droit", olivier.getDroit());
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}
}
