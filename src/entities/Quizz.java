package entities;

import java.util.*;

import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Quizz {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	// Identifiant du quizz
	private long num;
	// Cartes privatives
	private String carte1;
	private String couleur1;
	private String carte2;
	private String couleur2;
	// Position
	private String position;
	// Description de la situation générale
	private String situation;
	// Explications complémentaires optionnelles
	private String description;
	// Catégorie
	private String categorie;
	// Situation aux différentes streets
	private String preflop;
	private String flop;
	private String turn;
	private String river;
	
	// Option choisie  
		// PF
	private String choixPreflop;
		// F
	private String choixFlop;
		// T
	private String choixTurn;
		// R
	private String choixRiver;
	// Justifications 
	private String justificationPreflop;
	private String justificationFlop;
	private String justificationTurn;
	private String justificationRiver;
	
	@ManyToOne
	private Membre membre;
	@OneToMany(mappedBy="quizz") @LazyCollection(LazyCollectionOption.FALSE)
	private List<Reponse> reponses;
	
	public Quizz() {}
	

	public String getJustificationPreflop() {
		return justificationPreflop;
	}

	public void setJustificationPreflop(String justificationPreflop) {
		this.justificationPreflop = justificationPreflop;
	}

	public String getJustificationFlop() {
		return justificationFlop;
	}

	public void setJustificationFlop(String justificationFlop) {
		this.justificationFlop = justificationFlop;
	}

	public String getJustificationTurn() {
		return justificationTurn;
	}

	public void setJustificationTurn(String justificationTurn) {
		this.justificationTurn = justificationTurn;
	}

	public String getChoixPreflop() {
		return choixPreflop;
	}

	public void setChoixPreflop(String choixPreflop) {
		this.choixPreflop = choixPreflop;
	}

	public String getChoixFlop() {
		return choixFlop;
	}

	public void setChoixFlop(String choixFlop) {
		this.choixFlop = choixFlop;
	}

	public String getChoixTurn() {
		return choixTurn;
	}

	public void setChoixTurn(String choixTurn) {
		this.choixTurn = choixTurn;
	}

	public String getChoixRiver() {
		return choixRiver;
	}

	public void setChoixRiver(String choixRiver) {
		this.choixRiver = choixRiver;
	}

	public String getJustificationRiver() {
		return justificationRiver;
	}

	public void setJustificationRiver(String justificationRiver) {
		this.justificationRiver = justificationRiver;
	}

	public void setNum(long num) {
		this.num = num;
	}
	
	public long getNum() {
		return num;
	}
	
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	
	public Membre getMembre() {
		return membre;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setCarte1(String carte1) {
		this.carte1 = carte1;
	}

	public String getCarte1() {
		return carte1;
	}

	public void setCouleur1(String couleur1) {
		this.couleur1 = couleur1;
	}

	public String getCouleur1() {
		return couleur1;
	}

	public void setCarte2(String carte2) {
		this.carte2 = carte2;
	}

	public String getCarte2() {
		return carte2;
	}

	public void setCouleur2(String couleur2) {
		this.couleur2 = couleur2;
	}

	public String getCouleur2() {
		return couleur2;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getSituation() {
		return situation;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}
	
	public String getPreflop() {
		return preflop;
	}

	public void setPreflop(String preflop) {
		this.preflop = preflop;
	}

	public String getFlop() {
		return flop;
	}

	public void setFlop(String flop) {
		this.flop = flop;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getCategorie() {
		return categorie;
	}

	// Quelques methodes pour calculer des statistiques 
	

	// Pourcentage de personnes en accord avec la totalite du quizz
	public float statsQuizz() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).isTrue())
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else 
			return 0;
	} 
	
	// Les statistiques sur chaque avenue
	
	public float statsPreflopFold() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponsePreflop().equals("Fold")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsPreflopCall() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponsePreflop().equals("Call")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsPreflopRaise() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponsePreflop().equals("Raise")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsFlopFold() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponseFlop().equals("Fold")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsFlopCall() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponseFlop().equals("Call")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsFlopRaise() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponseFlop().equals("Raise")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsTurnFold() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponseTurn().equals("Fold")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsTurnCall() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponseTurn().equals("Call")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsTurnRaise() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponseTurn().equals("Raise")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsRiverFold() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponseRiver().equals("Fold")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsRiverCall() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponseRiver().equals("Call")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
	
	public float statsRiverRaise() {
		int totalReponses = this.reponses.size();
		int avisFavorables = 0;
		if (this.reponses.size()>0) {
			for (int i=0 ; i<this.reponses.size(); i++) {
				if (this.reponses.get(i).getReponseRiver().equals("Raise")) 
					avisFavorables++;
			}
			return (avisFavorables/totalReponses)*100;
		}
		else
			return 0;
	}
		
}
