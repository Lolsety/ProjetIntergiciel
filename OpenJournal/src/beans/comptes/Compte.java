package beans.comptes;

import java.util.Collection;

import javax.persistence.Entity;
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
	

	@OneToMany
	Collection<Article> articles;
	
	private String pseudoSite;
	private String email;
	private String nom;
	private String prenom;
	private int age;
	private Droit droit;
	
	@OneToMany
	private Collection<MessagePrive> mps;
	
	public Compte() {
		this.droit=Droit.UTILISATEUR;
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

	public void setMps(Collection<MessagePrive> mps) {
		this.mps = mps;
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
	
	public Collection<MessagePrive> getMps() {
		return mps;
	}

	
	

}
