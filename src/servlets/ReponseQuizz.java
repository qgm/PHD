package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.QuizzManager;
import entities.Quizz;

/**
 * Servlet implementation class RepondreQuizz
 */
public class ReponseQuizz extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
    private QuizzManager quizzM;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReponseQuizz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long num = Long.parseLong(id);
		Quizz q = quizzM.findByPK(num);
		request.setAttribute("quizz", q);
		RequestDispatcher redirection = request.getRequestDispatcher("ReponseQuizz.jsp");
		redirection.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
