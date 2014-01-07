package entities;

import java.util.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class Membre {

	@Id
	private String id;
	private String password;
	private String nom;
	private String prenom;
	private String email;
	private String ville;
	private int points;
	@OneToMany(mappedBy="membre")
	private List<Quizz> quizzs;
	@OneToMany(mappedBy="membre") @LazyCollection(LazyCollectionOption.FALSE)
	private List<Reponse> reponses;	
	
	public Membre(){
	}
	
	public String toString() {
		return id + " " + nom + " " + prenom + " " + password + " " + email + " " + ville;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setQuizzs(List<Quizz> quizzs) {
		this.quizzs = quizzs;
	}

	public List<Quizz> getQuizzs() {
		return quizzs;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
	
	public String rang() {
		String rang = new String("");
 		if (this.points < 20)
 			rang = "Débutant";
 		else if (this.points < 50)
 			rang = "Initié";
 		else if (this.points < 100 )
 			rang = "Challenger";
 		else 
 			rang = "Shark";
 		return rang;
	}
	
}
