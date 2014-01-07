package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Membre;

/**
 * Servlet implementation class Connexion
 */
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ejbs.MembreManager membreM;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("id").equals("") || request.getParameter("password").equals("")) {
			response.sendRedirect("Accueil.html");
		} else {
			Membre m = membreM.findByPK(request.getParameter("id"));
			if (m != null && request.getParameter("password").equals(m.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("id", request.getParameter("id"));
				// session.setAttribute("password",request.getParameter("password"));
				session.setAttribute("membre", m);
				RequestDispatcher redirection = request.getRequestDispatcher("/EspaceMembre");
				redirection.forward(request, response);
				// response.sendRedirect("EspaceMembre.jsp");
			} else {
				response.sendRedirect("Accueil.html");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
