package beans;

import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sun.util.calendar.BaseCalendar.Date;
import exception.CompteDejaCree;
import beans.comptes.Compte;
import beans.droits.Droit;
import beans.texte.Article;

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
	public void ajouterCompte(String pseudoLDAP,String pseudoSite,String email,String nom,String prenom,String age,Droit droit) throws CompteDejaCree {
		if (getCompteUtilisateur(pseudoLDAP)!=null) {
			throw new exception.CompteDejaCree();
		}
		// TODO : vérifier qu'un compte avec pseudoSite n'existe pas
		Compte c = new Compte(pseudoLDAP, pseudoSite, email, nom, prenom, Integer.parseInt(age), droit);
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
	
	public void modifierDroit(String pseudoLDAP, Droit droit) {
		getCompteUtilisateur(pseudoLDAP).setDroit(droit);
	}
	
	public void ajouterArticle(String pseudoLDAP, String titre, String corps) {
		Article article = new Article(getCompteUtilisateur(pseudoLDAP),12012015,titre);
		em.persist(article);
		article.setContenu(corps);
	}
}
