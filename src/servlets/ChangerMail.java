package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Membre;

/**
 * Servlet implementation class ChangerMail
 */
public class ChangerMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ejbs.MembreManager membreM;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangerMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Membre m = (Membre) session.getAttribute("membre");
		if (request.getParameter("password").equals(m.getPassword())) {
			membreM.modifierParam(m, "email", request.getParameter("email"));
			session.setAttribute("membre", m);
			response.sendRedirect("/PHD/EspaceMembre");
		} else {
			response.sendRedirect("ChangementMail.html");
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