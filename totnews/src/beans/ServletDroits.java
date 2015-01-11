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
import beans.droits.Droit;

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
		Collection<Compte> listeComptes=facade.getComptes();
		request.setAttribute("listeComptes", listeComptes);
		if(op.equals("GererDroits")) {
			request.getRequestDispatcher("/WEB-INF/restricted/gererDroits.jsp").forward(request,response);
		} else if (op.equals("modifDroits")) {
			String pseudoLDAP = request.getParameter("Compte");
			Droit droit = Droit.valueOf(request.getParameter("Droit"));
			facade.modifierDroit(pseudoLDAP,droit);
			request.getRequestDispatcher("/WEB-INF/restricted/gererDroits.jsp").forward(request,response);
			
		}
	}		


}
