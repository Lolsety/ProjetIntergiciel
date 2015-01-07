package texte;

//@Stateful
public class MessagePrive extends Texte {
	public MessagePrive(compte.Compte compte, String text, int datePub){
		this.auteur = compte;
		this.text = text;
		this.datePub = datePub;
	}

}
