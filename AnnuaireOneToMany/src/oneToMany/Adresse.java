package oneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adresse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Personne proprietaire;
	

	private String rue, ville;
	
	public Adresse() {
		super();
	}
	
	public Adresse(String rue, String ville) {
		this.rue = rue;
		this.ville = ville;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Personne getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Personne proprietaire) {
		this.proprietaire = proprietaire;
	}
}
