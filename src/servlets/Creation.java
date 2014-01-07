package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Membre;
import entities.Quizz;
import ejbs.QuizzManager;
import ejbs.MembreManager;

/**
 * Servlet implementation class CreerQuizz
 */
public class Creation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    private QuizzManager quizzM;
    @EJB
    private MembreManager membreM;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Creation() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quizz quizz = this.quizzM.CreateFromRequest(request);
		// Eventuelle erreur de saisie
		Integer erreurCreation = new Integer(erreurCreation(quizz));
		request.setAttribute("erreur", erreurCreation);
		if (!erreurCreation.equals(new Integer(0))) {
			RequestDispatcher redirection = request.getRequestDispatcher("CreerQuizz.jsp");
			redirection.forward(request, response);
		} else {
			// Association au membre 
			Membre m = (Membre) request.getSession().getAttribute("membre");
			quizz.setMembre(m);
			// Ajout du quizz dans la BDD
			quizzM.addQuizz(quizz);
			// Incrémentation du nombre de points du posteur
			membreM.augmenterPoints(m, 1);
			// Visualisation du Quizz ?
			response.sendRedirect("/PHD/EspaceMembre");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	// vérifie que l'inscription est valide
	private int erreurCreation (Quizz q){
		//champs imcomplets ou vide
		boolean parametreVide = 
			   q.getCarte1()==null
			|| q.getCouleur1() ==null
			|| q.getCarte2() ==null
			|| q.getCouleur2()==null
			|| q.getPosition()==null
			|| q.getCategorie()==null
			|| q.getSituation()==null
			|| q.getPreflop() == null
			;
		if (!parametreVide){
			parametreVide = 
				       q.getCarte1().equals(" ")
					|| q.getCouleur1().equals(" ")
					|| q.getCarte2().equals(" ")
					|| q.getCouleur2().equals(" ")
					|| q.getPosition().equals(" ")
					|| q.getSituation().equals(" ")
					|| q.getDescription().equals(" ")
					|| q.getPreflop().equals(" ")
					;
		}
		
		boolean cartesIdentiques = (q.getCarte1().equals(q.getCarte2())) && (q.getCouleur1().equals(q.getCouleur2()));
				
		if (parametreVide)
			return 1;
		else if (cartesIdentiques)
			return 2;
		else
			return 0;	
	}
	
}