package beans;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if (op.equals ("accederMessagerie")) {
			request.getRequestDispatcher("messagerie.jsp").forward(request,response);
		} else if (op.equals ("envoiMessage")) {
			request.getRequestDispatcher("messagerie.jsp").forward(request,response);
			
		} else if (op.equals ("lireMessage")) {
			request.getRequestDispatcher("lireMessage.jsp").forward(request,response);		
		}
	}
}