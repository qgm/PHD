package ejbs;

import java.util.*;

import javax.ejb.*;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import entities.Quizz;

@Stateless
public class QuizzManager {
	
	@PersistenceContext
	EntityManager em;

	public entities.Quizz findByPK(long num){
		return (entities.Quizz) em.find(entities.Quizz.class, num);
	}
	
	public void addQuizz(Quizz quizz) {
		em.persist(quizz);
	}

	public Quizz CreateFromRequest(HttpServletRequest request){
		Quizz q = new Quizz();
		Enumeration<String> parameterNames= request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String key = (String) parameterNames.nextElement();
			if (key.equals("carte1"))
				q.setCarte1(request.getParameter(key)); 
			if (key.equals("couleur1"))
				q.setCouleur1(request.getParameter(key));
			if (key.equals("carte2"))
				q.setCarte2(request.getParameter(key));	
			if (key.equals("couleur2"))
				q.setCouleur2(request.getParameter(key));	
			if (key.equals("situation"))
				q.setSituation(request.getParameter(key));
			if (key.equals("description"))
				q.setDescription(request.getParameter(key));
			if (key.equals("position"))
				q.setPosition(request.getParameter(key));
			if (key.equals("categorie"))
				q.setCategorie(request.getParameter(key));
			if (key.equals("preflop"))
				q.setPreflop(request.getParameter(key));
			if (key.equals("flop"))
				q.setFlop(request.getParameter(key));
			if (key.equals("turn"))
				q.setTurn(request.getParameter(key));
			if (key.equals("river"))
				q.setRiver(request.getParameter(key));
			if (key.equals("choixPreflop"))
				q.setChoixPreflop(request.getParameter(key));
			if (key.equals("choixFlop"))
				q.setChoixFlop(request.getParameter(key));
			if (key.equals("choixTurn"))
				q.setChoixTurn(request.getParameter(key));
			if (key.equals("choixRiver"))
				q.setChoixRiver(request.getParameter(key));
			if (key.equals("justificationPreflop"))
				q.setJustificationPreflop(request.getParameter(key));
			if (key.equals("justificationFlop"))
				q.setJustificationFlop(request.getParameter(key));
			if (key.equals("justificationTurn"))
				q.setJustificationTurn(request.getParameter(key));
			if (key.equals("justificationRiver"))
				q.setJustificationRiver(request.getParameter(key));
		}
		return q;
	}
	
	// le parametre type correspond a Assorties ou Depareillees (ou tous les types de main)
	@SuppressWarnings("unchecked")
	public List<Quizz> FindbyCards(String carte1, String carte2, String type) {
		String requete = new String("");		
		if (type.equals("suited")) {
			requete = "SELECT q FROM Quizz As q WHERE q.couleur1 = q.couleur2 AND " +
				"((q.carte1 = '"+ carte1+"' AND q.carte2 = '"+ carte2 +"') OR (q.carte1 = '"+ carte2+"' AND q.carte2 = '"+ carte1 +"'))";
		}
		else if (type.equals("offsuit")){
			requete = "SELECT q FROM Quizz As q WHERE q.couleur1 <> q.couleur2 AND " +
				"(q.carte1 = '"+ carte1+"' AND q.carte2 = '"+ carte2 +"') OR (q.carte1 = '"+ carte2+"' AND q.carte2 = '"+ carte1 +"')";
		}
		else {
			requete = "SELECT q FROM Quizz As q WHERE " +
				"q.carte1 = '"+ carte1+"' AND q.carte2 = '"+ carte2 +"') OR (q.carte1 = '"+ carte2+"' AND q.carte2 = '"+ carte1 +"'";
		}		
		
		List<Quizz> l = null;
		try {
			 l = em.createQuery(requete).getResultList();
			}catch (Exception ex){
				ex.printStackTrace();
			}
		return l;	
	} 
	
	// Selectionne tous les Quizz
	@SuppressWarnings("unchecked")
	public List<Quizz> FindAll() {
		String requete = new String("");		
		requete = "SELECT q FROM Quizz As q";
		List<Quizz> l = null;
		try {
			 l = em.createQuery(requete).getResultList();
			}catch (Exception ex){
				ex.printStackTrace();
			}
		return l;	
	} 
		
}