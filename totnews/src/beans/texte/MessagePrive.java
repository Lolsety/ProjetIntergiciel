package beans.texte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import beans.comptes.Compte;

//@Stateful
@Entity
public class MessagePrive extends Texte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public MessagePrive(Compte compte, String text, int datePub){
		this.auteur = compte;
		this.text = text;
		this.datePub = datePub;
	}

}
