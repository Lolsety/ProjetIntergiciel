package texte;

public abstract class Texte {
	compte.Compte auteur;
	int datePub;
	String text;
	
	public compte.Compte getAuteur() {
		return auteur;
	}
	public void setAuteur(compte.Compte auteur) {
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
