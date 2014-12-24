package oneToMany;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Personne {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nom, prenom;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "proprietaire")
	private Collection<Adresse> adressesPers;

	public Personne() {
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Adresse> getAdressesPers() {
		return adressesPers;
	}

	public void setAdressesPers(Collection<Adresse> adressesPers) {
		this.adressesPers = adressesPers;
	}
	
}
