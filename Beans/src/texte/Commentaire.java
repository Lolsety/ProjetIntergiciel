package texte;

//@Stateful
public class Commentaire extends Texte {
	public Commentaire(compte.Compte compte, String text, int datePub){
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
