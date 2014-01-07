package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.*;
import entities.*;

/**
 * Servlet implementation class Resultat
 */
public class Resultat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	QuizzManager quizzM;
	@EJB
	ReponseManager reponseM;
	@EJB
	MembreManager membreM;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resultat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ajout de quizz dans la requete
		String id = request.getParameter("id");
		long num = Long.parseLong(id);
		Quizz quizz = quizzM.findByPK(num);
		request.setAttribute("quizz",quizz);
		
		// Ajout de reponse dans la requete
		Reponse reponse = reponseM.CreateFromRequest(request);
		request.setAttribute("reponse",reponse);
		
		// Gestion de l'erreur
		Integer erreur = new Integer(erreurReponse(reponse, quizz));
		request.setAttribute("erreur", erreur);
		if (erreur.equals(new Integer(1))) {
			RequestDispatcher redirection = request.getRequestDispatcher("reponse.do");
			redirection.forward(request, response);
		}
		else {
		// Ajout du quizz dans reponse
		reponse.setQuizz(quizz);
		Membre m = (Membre) request.getSession().getAttribute("membre");
		
		// Ajout de reponse dans la BDD
		reponseM.addReponse(reponse);
		
		// Mise à jour des points du joueur
		membreM.augmenterPoints(m, reponse.pointsObtenus());		
		
		// Redirection
		RequestDispatcher redirection = request.getRequestDispatcher("ResultatQuizz.jsp");
		redirection.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	// vérifie que la réponse est conforme
	private int erreurReponse (Reponse r, Quizz q){
		//Reponse aux avenues non remplies
		boolean parametreVide = (r.getReponsePreflop()==null || r.getReponsePreflop().equals(" "));
		if (!(q.getChoixFlop() == null)) { 
			if (!(q.getChoixFlop().equals(" "))) {
				if (r.getReponseFlop()==null || r.getReponseFlop().equals(" "))
					parametreVide = true;
				if (!(q.getChoixTurn() == null)) {
					if (!(q.getChoixTurn().equals(" "))) {
						if (r.getReponseTurn()==null || r.getReponseTurn().equals(" ")) 
							parametreVide = true;
						if (!(q.getChoixRiver() == null)) {
							if (!(q.getChoixRiver().equals(" "))) {
								if (r.getReponseRiver()==null || r.getReponseRiver().equals(" "))
									parametreVide = true;
							}
						}
					}
				}
			}
		}
		if (parametreVide)
			return 1;
		else
			return 0;
	}

}
