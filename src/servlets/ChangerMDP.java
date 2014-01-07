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
 * Servlet implementation class ChangerMDP
 */
public class ChangerMDP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ejbs.MembreManager membreM;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangerMDP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (request.getParameter("password").equals(request.getParameter("password2"))) {
			Membre m = (Membre) session.getAttribute("membre");
			if (request.getParameter("oldpassword").equals(m.getPassword())) {
				membreM.modifierParam(m, "password", request.getParameter("password"));
				session.setAttribute("membre", m);
				response.sendRedirect("/PHD/EspaceMembre");
			}
			else 
				response.sendRedirect("ChangementMDP.html");
		} else
			response.sendRedirect("ChangementMDP.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}