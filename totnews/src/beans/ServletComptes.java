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
		try {
			String op=request.getParameter("op");
			Compte compte=facade.getCompteUtilisateur(request.getUserPrincipal().getName());
			
			if (op.equals("RetourIndex")) {
				//c'est juste un test
				facade.setDroitUtilisateur(Droit.ADMNINISTRATEUR, compte);
				request.setAttribute("droit", compte.getDroit());
				request.getRequestDispatcher("/WEB-INF/restricted/index.jsp").forward(request,response);
			} else if (op.equals("Deconnexion")) {
				
				request.getRequestDispatcher("ServletComptes");
				request.getSession().invalidate();
			}
		} catch (NullPointerException e) {
			request.getRequestDispatcher("/index.html");
		}
				
	}
}
