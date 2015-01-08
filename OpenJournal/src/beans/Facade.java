package beans;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.comptes.Compte;
import beans.droits.Droit;

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
	
	public void setDroitUtilisateur(Droit droit, Compte compte) {
		compte.setDroit(droit);
		}
	
	public Compte getCompteUtilisateur(String user) {
		return em.find(Compte.class, user);
	}
	
	public Collection<Compte> getComptes() {
		return em.createQuery("from Compte", Compte.class).getResultList();
	}
}
