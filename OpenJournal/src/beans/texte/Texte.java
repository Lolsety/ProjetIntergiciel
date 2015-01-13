package beans.texte;

import java.util.Date;

import beans.comptes.Compte;

public abstract class Texte {
	Compte auteur;
	Date datePub;
	String text;
	
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
