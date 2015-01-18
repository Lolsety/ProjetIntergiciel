package beans.texte;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import beans.comptes.Compte;

//@Stateful
@Entity
public class MessagePrive  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Compte destinataire;

	@OneToOne
	private Compte auteur;
	
	private Date datePub;
	private String text;
	private String objet;

	public MessagePrive () {}
	

	public MessagePrive(Compte auteur, String text, Compte destinataire, String objet, Date datePub){
		this.auteur = auteur;
		this.text = text;
		this.destinataire=destinataire;
		this.datePub = datePub;
		this.objet=objet;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Compte getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Compte destinataire) {
		this.destinataire = destinataire;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
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
