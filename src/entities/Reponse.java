package entities;

import javax.persistence.*;

@Entity
public class Reponse {

	@Id
	@GeneratedValue
	// Identifiant de la reponse
	private long num;
	// Option choisie et eventuelle justification
	// PF
	private String reponsePreflop;
	private String justificationPreflop;
	// F
	private String reponseFlop;
	private String justificationFlop;
	// T
	private String reponseTurn;
	private String justificationTurn;
	// R
	private String reponseRiver;
	private String justificationRiver;
	// Explications eventuelles
	private String explications;	
	
	@ManyToOne
	private Quizz quizz; // A initialiser dans la servlet
	@ManyToOne
	private Membre membre; // A initialiser dans la servlet
	
	// REQUETES ET ACCESSEURS

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

	public String getJustificationRiver() {
		return justificationRiver;
	}

	public void setJustificationRiver(String justificationRiver) {
		this.justificationRiver = justificationRiver;
	}


	
		public String getReponsePreflop() {
			return reponsePreflop;
		}

		public void setReponsePreflop(String reponsePreflop) {
			this.reponsePreflop = reponsePreflop;
		}

		public String getReponseFlop() {
			return reponseFlop;
		}

		public void setReponseFlop(String reponseFlop) {
			this.reponseFlop = reponseFlop;
		}

		public String getReponseTurn() {
			return reponseTurn;
		}

		public void setReponseTurn(String reponseTurn) {
			this.reponseTurn = reponseTurn;
		}

		public String getReponseRiver() {
			return reponseRiver;
		}

		public void setReponseRiver(String reponseRiver) {
			this.reponseRiver = reponseRiver;
		}

		public Reponse(){
	}

	public void setNum(long num) {
		this.num = num;
	}

	public long getNum() {
		return num;
	}

	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}

	public Quizz getQuizz() {
		return quizz;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setExplications(String explications) {
		this.explications = explications;
	}

	public String getExplications() {
		return explications;
	}
	
	public int pointsObtenus() {
		int pts = 0;
		if (this.reponsePreflop.equals(this.quizz.getChoixPreflop()))
			pts++;
		if (!(this.quizz.getChoixFlop() == null)) { 
			if (!(this.quizz.getChoixFlop().equals(" "))) {
				if (this.reponseFlop.equals(this.quizz.getChoixFlop())) 
					pts++;
				if (!(this.quizz.getChoixTurn() == null)) {
					if (!(this.quizz.getChoixTurn().equals(" "))) {
						if (this.reponseTurn.equals(this.quizz.getChoixTurn())) 
							pts++;
						if (!(this.quizz.getChoixRiver() == null)) {
							if (!(this.quizz.getChoixRiver().equals(" "))) {
								if (this.reponseRiver.equals(this.quizz.getChoixRiver()))
									pts++;
							}
						}
					}
				}
			}
		}
		return pts;			
	}
	
	public boolean isTrue() {
		boolean correct = false;
		if (this.reponsePreflop.equals(this.quizz.getChoixPreflop()))
			correct = true;
		if (!(this.quizz.getChoixFlop() == null)) { 
			if (!(this.quizz.getChoixFlop().equals(" "))) {
				if (this.reponseFlop.equals(this.quizz.getChoixFlop())) 
					correct = correct && true;
				else 
					correct = correct && false;
				if (!(this.quizz.getChoixTurn() == null)) {
					if (!(this.quizz.getChoixTurn().equals(" "))) {
						if (this.reponseTurn.equals(this.quizz.getChoixTurn())) 
							correct = correct && true;
						else
							correct = correct && false;
						if (!(this.quizz.getChoixRiver() == null)) {
							if (!(this.quizz.getChoixRiver().equals(" "))) {
								if (this.reponseRiver.equals(this.quizz.getChoixRiver()))
									correct = correct && true;
								else
									correct = correct && false;
							}
						}
					}
				}
			}
		}
		return correct;
	} 

}
