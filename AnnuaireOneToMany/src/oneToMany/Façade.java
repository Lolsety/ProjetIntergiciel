package oneToMany;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

@Singleton
public class Façade {

	@PersistenceContext
	private EntityManager em;
	
	public Façade() {}
	
	public void ajoutPersonne(String nom, String prenom){
		Personne p = new Personne();
		p.setNom(nom);
		p.setPrenom(prenom);
	    em.persist(p);
	}
	
	public void ajoutAdresse(String rue, String ville){
		Adresse a = new Adresse();
		a.setRue(rue);
		a.setVille(ville);
		em.persist(a);
	}
	
	public Collection<Personne> listePersonnes() {
		return em.createQuery("from Personne", Personne.class).getResultList();
	}
	
	public Collection<Adresse> listeAdresses() {
		return em.createQuery("from Adresse", Adresse.class).getResultList();
	}
	
	public void associer(int personneId, int adresseId) {
		Personne p = em.find(Personne.class, personneId);
		Adresse a = em.find(Adresse.class, adresseId);
		a.setProprietaire(p);
	}
	
}
