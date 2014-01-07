package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Quizz;
import ejbs.QuizzManager;

/**
 * Servlet implementation class EspaceMembre
 */
public class EspaceMembre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private QuizzManager quizzM;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EspaceMembre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Quizz> quizzs = quizzM.FindAll();
		request.setAttribute("quizzs", quizzs);
		RequestDispatcher redirection = request.getRequestDispatcher("EspaceMembre.jsp");
		redirection.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
