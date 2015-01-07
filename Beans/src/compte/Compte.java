
package compte;

import java.util.Collection;
import java.util.HashSet;
//@Stateful
public class Compte {
	private String nom;
	private String prenom;
	private int age;
	private droits.Droit droit;
	private Collection<texte.MessagePrive> mps;
	
	public Compte(String nom, String prenom,  int age, droits.Droit droit)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.droit = droit;
		this.mps = new HashSet<texte.MessagePrive>() ;
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
	
	public droits.Droit getDroit() {
		return droit;
	}
	public void setDroit(droits.Droit droit) {
		this.droit = droit;
	}
	
	public Collection<texte.MessagePrive> getMps() {
		return mps;
	}

	
	

}
