package beans.texte;

import beans.comptes.Compte;

public abstract class Texte {
	Compte auteur;
	int datePub;
	String text;
	
	public Compte getAuteur() {
		return auteur;
	}
	public void setAuteur(Compte auteur) {
		this.auteur = auteur;
	}
	public int getDatePub() {
		return datePub;
	}
	public void setDatePub(int datePub) {
		this.datePub = datePub;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
