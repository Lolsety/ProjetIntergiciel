package beans.texte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import beans.comptes.Compte;

//@Stateful
@Entity
public class Article extends Texte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String titre;
	
	public Article(Compte compte, String text, int datePub, String titre){
		this.auteur = compte;
		this.text = text;
		this.datePub = datePub;
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
}
