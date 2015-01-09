package beans;


import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.comptes.Compte;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletDroits")
public class ServletDroits extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	Facade facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDroits() {
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
		//comptes pour tester, ATTENTION : si on lance 2x ce servlet, il va y avoir une erreur car on essaie de réécrire
		//dans la BD des comptes déjà existant, la clé devant rester unique
		facade.ajouterCompte("damien");
		Compte damien=facade.getCompteUtilisateur("damien");
		facade.ajouterCompte("thibault");
		facade.ajouterCompte("tom");
		
		Collection<Compte> listeComptes=facade.getComptes();
		
		if(op.equals("GererDroits")) {
			facade.setNomUtilisateur("Delage", damien);
			facade.setPrenomUtilisateur("Damien", damien);
			request.setAttribute("listeComptes", listeComptes);
			request.getRequestDispatcher("gererDroits.jsp").forward(request,response);
		}
	}		


}
