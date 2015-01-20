package beans.texte;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import beans.comptes.Compte;

//@Stateful
@Entity
public class Commentaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Compte auteur;
	
	@OneToOne
	private Article article;
	
	private Date datePub;
	private String text;
	
	
	public Commentaire(Compte compte, Article article, String text, Date datePub){
		this.auteur = compte;
		this.text = text;
		this.datePub = datePub;
		this.article= article;
	}
	@Override public void setText(String text) {
		if (text.length()<200) {
			this.text = text;
		}
	}
	

	public Compte getAuteur() {
		return auteur;
	}
	public void setAuteur(Compte auteur) {
		this.auteur = auteur;
	}
	public Date getDatePub() {
		return datePub;
	}
	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
