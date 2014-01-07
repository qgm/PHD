package ejbs;

import java.util.Enumeration;

import javax.ejb.*;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import entities.Reponse;

@Stateless
public class ReponseManager {
	
	@PersistenceContext
	EntityManager em;

	public Reponse findByPK(long num){
		return (Reponse) em.find(Reponse.class, num);
	}
	
	public void addReponse(Reponse reponse) {
		em.persist(reponse);
	}
	
	public Reponse CreateFromRequest(HttpServletRequest request){
		Reponse r = new Reponse();
		Enumeration<String> parameterNames= request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String key = (String) parameterNames.nextElement();
			if (key.equals("reponsePreflop"))
				r.setReponsePreflop(request.getParameter(key));
			if (key.equals("reponseFlop"))
				r.setReponseFlop(request.getParameter(key));	
			if (key.equals("reponseTurn"))
				r.setReponseTurn(request.getParameter(key));	
			if (key.equals("reponseRiver"))
				r.setReponseRiver(request.getParameter(key));
			if (key.equals("explications"))
				r.setExplications(request.getParameter(key));
			if (key.equals("justificationPreflop"))
				r.setJustificationPreflop(request.getParameter(key));
			if (key.equals("justificationFlop"))
				r.setJustificationFlop(request.getParameter(key));
			if (key.equals("justificationTurn"))
				r.setJustificationTurn(request.getParameter(key));
			if (key.equals("justificationRiver"))
				r.setJustificationRiver(request.getParameter(key));
		}
		return r;
	}
}