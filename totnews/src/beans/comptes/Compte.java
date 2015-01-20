package beans.comptes;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import beans.droits.Droit;
import beans.texte.Article;
import beans.texte.MessagePrive;
//@Stateful
@Entity
public class Compte {
	
	

	@Id
	String pseudoLdap;
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "auteur")
	Collection<Article> articles;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "auteur")
	Collection<Commentaire> commentaires;
	
	private String pseudoSite;
	private String email;
	private String nom;
	private String prenom;
	private int age;
	private Droit droit;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "destinataire")
	private Collection<MessagePrive> mpRecus;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "auteur")
	private Collection<MessagePrive> mpEnvoyes;
	
	public Compte() {}
	
	public Compte(String pseudoLdap,String pseudoSite, String email, String nom, String prenom,
			int age, Droit droit) {
		super();
		this.pseudoLdap = pseudoLdap;
		this.pseudoSite = pseudoSite;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.droit = droit;
	}
	
	public String getPseudoLdap() {
		return pseudoLdap;
	}

	public void setPseudoLdap(String pseudoLdap) {
		this.pseudoLdap = pseudoLdap;
	}

	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPseudoSite() {
		return pseudoSite;
	}

	public void setPseudoSite(String pseudoSite) {
		this.pseudoSite = pseudoSite;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Droit getDroit() {
		return droit;
	}
	public void setDroit(Droit droit) {
		this.droit = droit;
	}

	public Collection<MessagePrive> getMpRecus() {
		return mpRecus;
	}

	public void setMpRecus(Collection<MessagePrive> mpRecus) {
		this.mpRecus = mpRecus;
	}

	public Collection<MessagePrive> getMpEnvoyes() {
		return mpEnvoyes;
	}

	public void setMpEnvoyes(Collection<MessagePrive> mpEnvoyes) {
		this.mpEnvoyes = mpEnvoyes;
	}

	
	

}
