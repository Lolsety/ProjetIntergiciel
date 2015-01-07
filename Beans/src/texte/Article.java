package texte;
//@Stateful
public class Article extends Texte {
	String titre;
	
	public Article(compte.Compte compte, String text, int datePub, String titre){
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
