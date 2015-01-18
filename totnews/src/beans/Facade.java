package beans;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import exception.CompteDejaCree;
import exception.PseudoDejaUtilise;
import beans.comptes.Compte;
import beans.droits.Droit;
import beans.texte.Article;
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
	public void ajouterCompte(String pseudoLDAP,String pseudoSite,String email,String nom,String prenom,String age,Droit droit) throws CompteDejaCree, PseudoDejaUtilise {
		if (getCompteUtilisateur(pseudoLDAP)!=null) {
			throw new exception.CompteDejaCree();
		} else if (!em.createQuery("from Compte where pseudoSITE = \'" + pseudoSite + "\'",Compte.class).getResultList().isEmpty()){
			throw new exception.PseudoDejaUtilise();
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
	
	public Compte getCompteUtilisateurPseudoSite(String pseudoSite) {
		try {
			return em.createQuery("from Compte where pseudoSITE = \'" + pseudoSite + "\'",Compte.class).getSingleResult();
		} catch (Exception e) {
			// Destinataire inconnu
			return null;
		}
	}
	
	public Collection<Compte> getComptes() {
		return em.createQuery("from Compte", Compte.class).getResultList();
	}
	
	public Collection<Article> getArticles() {
		return em.createQuery("from Article", Article.class).getResultList();
	}
	
	public void modifierDroit(String pseudoLDAP, Droit droit) {
		getCompteUtilisateur(pseudoLDAP).setDroit(droit);
	}
	
	public void ajouterArticle(String pseudoLDAP, String titre, String corps, Date date) {
		Article article = new Article(getCompteUtilisateur(pseudoLDAP),date,titre);
		em.persist(article);
		article.setContenu(corps);
	}
	
	public Article getArticle(String id) {
		if (id==null) {
			return null;
		}
		return em.createQuery("from Article where id = \'" + id + "\'",Article.class).getSingleResult();
	}
	
	public boolean publierArticle(String id) {
		Article a = getArticle(id);
		a.setPublicationAutorise(!a.isPublicationAutorise());
		return a.isPublicationAutorise();
	}
	public void ajouterMessage(Compte compte, String text, Compte compteDestinataire, String objet, Date datePub) {
		MessagePrive mp = new MessagePrive(compte, text, compteDestinataire, objet, datePub);
		em.persist(mp);
	}
	
	public MessagePrive getMessagePrive(int id) {
		return em.find(MessagePrive.class, id);
	}
	
	public Collection<MessagePrive> getMessagesPrivesRecus(Compte compte) {
		return compte.getMpRecus();
	}
	
	public Collection<MessagePrive> getMessagesPrivesEnvoyes(Compte compte) {
		return compte.getMpEnvoyes();
	}

	public void modifierArticle(String id, String name, String titre,
			String corps, Date date) {
		Article a = this.getArticle(id);
		if (a==null) {
			System.out.println("Article non trouvé : " + id);
		} else {
			a.setTitre(titre);
			a.setContenu(corps);
			a.setDateModif(date);
		}
		
	}
}
