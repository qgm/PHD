package ejbs;

import java.util.Enumeration;

import javax.ejb.*;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import entities.Membre;

@Stateless
public class MembreManager {
	
	@PersistenceContext
	EntityManager em;

	public entities.Membre findByPK(String id){
		return (entities.Membre) em.find(entities.Membre.class, id);
	}
	
	public void addMembre(Membre membre) {
		em.persist(membre);
	}

	public Membre CreateFromRequest(HttpServletRequest request){
		Membre m = new Membre();
		Enumeration<String> parameterNames= request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String key = (String) parameterNames.nextElement();
			if (key.equals("id"))
				m.setId(request.getParameter(key)); 
			if (key.equals("password"))
				m.setPassword(request.getParameter(key));
			if (key.equals("nom"))
				m.setNom(request.getParameter(key));	
			if (key.equals("prenom"))
				m.setPrenom	(request.getParameter(key));	
			if (key.equals("email"))
				m.setEmail(request.getParameter(key));
			if (key.equals("ville"))
				m.setVille(request.getParameter(key));
		}
		m.setPoints(0);
		return m;
	}
	
	public void modifierMdp(entities.Membre m, String nv_mdp) {
		m.setPassword(nv_mdp);
		em.merge(m);
	}
	
	public void modifierParam(entities.Membre m, String attr, String nv_attr) {
		if (attr.equals("password")) {
			m.setPassword(nv_attr);
		} else if (attr.equals("ville")){
			m.setVille(nv_attr);
		} else if (attr.equals("email")) {
			m.setEmail(nv_attr);
		}
		em.merge(m);
	}
	
	public void augmenterPoints(entities.Membre m, int nb) {
		int points = m.getPoints();
		m.setPoints(points + nb);
		em.merge(m);
	}
}
