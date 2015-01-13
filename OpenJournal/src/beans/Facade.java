package beans;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.comptes.Compte;
import beans.droits.Droit;
import beans.texte.MessagePrive;

@Singleton
public class Facade {

	@PersistenceContext
	private EntityManager em;
	
	public Facade() {}
	
	public void ajouterCompte(String pseudo) {
		Compte c = new Compte();
		c.setPseudoLdap(pseudo);
		em.persist(c);
	}
	
	public void setNomUtilisateur(String nom, Compte compte) {
		compte.setNom(nom);
	}
	
	public void setPrenomUtilisateur(String prenom, Compte compte) {
		compte.setPrenom(prenom);
	}
	
	public void setDroitUtilisateur(Droit droit, Compte compte) {
		compte.setDroit(droit);
	}
	
	public Compte getCompteUtilisateur(String user) {
		return em.find(Compte.class, user);
	}
	
	public Collection<Compte> getComptes() {
		return em.createQuery("from Compte", Compte.class).getResultList();
	}
	
	public void ajouterMessage(Compte compte, String text, Compte compteDestinataire, String objet, Date datePub) {
		MessagePrive mp = new MessagePrive(compte, text, compteDestinataire, objet, datePub);
		em.persist(mp);
	}
}
