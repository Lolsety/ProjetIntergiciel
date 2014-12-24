package oneToMany;


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
		Collection<Personne> listePersonnes = façade.listePersonnes();
		Collection<Adresse> listeAdresses = façade.listeAdresses();
		String op=request.getParameter("op");
		
		if(op.equals("ajoutPers")) {
			façade.ajoutPersonne(request.getParameter("Nom"), request.getParameter("Prenom"));
			request.getRequestDispatcher("index.html").forward(request,response);
			
		} else if (op.equals("ajoutAdres")) {
			façade.ajoutAdresse(request.getParameter("Rue"), request.getParameter("Ville"));
			request.getRequestDispatcher("index.html").forward(request,response);
			
		} else if (op.equals("lister")){
			request.setAttribute("listePersonnes", listePersonnes);
			request.getRequestDispatcher("lister.jsp").forward(request,response);
			
		} else if (op.equals("associer")) {
			request.setAttribute("listePersonnes", listePersonnes);
			request.setAttribute("listeAdresses", listeAdresses);
			request.getRequestDispatcher("choix.jsp").forward(request, response);
			
		} else if (op.equals("association")) {
			String personne = request.getParameter("Personne");
			String adresse = request.getParameter("Adresse");
			int personneId = Integer.parseInt(personne);
			int adresseId = Integer.parseInt(adresse);
			façade.associer(personneId, adresseId);
			request.getRequestDispatcher("index.html").forward(request,response);
		}
	}

}
