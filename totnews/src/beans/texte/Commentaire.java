package beans.texte;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import beans.comptes.Compte;

//@Stateful
@Entity
public class Commentaire extends Texte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public Commentaire(Compte compte, String text, Date datePub){
		this.auteur = compte;
		this.text = text;
		this.datePub = datePub;
	}
	@Override public void setText(String text) {
		if (text.length()<200) {
			this.text = text;
		}
	}
}
