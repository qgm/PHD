package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Membre;

/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ejbs.MembreManager membreM;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Membre membre;
		membre = membreM.CreateFromRequest(request);
		Integer erreurInscription = new Integer(erreurInscription(membre,request.getParameter("password2")));
		request.setAttribute("erreur", erreurInscription);
		if (!erreurInscription.equals(new Integer(0))) {
			RequestDispatcher redirection = request.getRequestDispatcher("Inscription.jsp");
			redirection.forward(request, response);
		} else {
			membreM.addMembre(membre);
			RequestDispatcher redirection = request.getRequestDispatcher("connexion.do");
			redirection.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
	// vérifie que l'inscription est valide
	private int erreurInscription (Membre m, String pwd){
		//champs imcomplets ou vide
		boolean parametreVide = m.getId()==null
		|| m.getPassword()==null
		|| pwd==null
		|| m.getNom()==null
		|| m.getPrenom()==null
		|| m.getEmail()==null
		|| m.getVille()==null
		|| m.getEmail()==null ;
		if (!parametreVide){
			parametreVide = m.getId().equals(" ")
					|| m.getPassword().equals(" ")
					|| pwd.equals(" ")
					|| m.getNom().equals(" ")
					|| m.getPrenom().equals(" ")
					|| m.getEmail().equals(" ")
					|| m.getVille().equals(" ")
					|| m.getEmail().equals(" ") ;
		}

		//mauvais mot de passe
		boolean mauvaisPassword= false; 
		if (m.getPassword()!=null ){
			mauvaisPassword = !m.getPassword().equals(pwd);
		}
		
		// données dejà utilisées (BD)
		boolean dejaUtilise = membreM.findByPK(m.getId())!=null;
		
		if (dejaUtilise)
			return 1;
		else if (mauvaisPassword)
			return 2;
		else if (parametreVide)
			return 3;
		else 
			return 0;	
	}


}
