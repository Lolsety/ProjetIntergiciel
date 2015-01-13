package beans;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.comptes.Compte;
import beans.texte.MessagePrive;

@Singleton
public class FacadeMessagerie {

	@PersistenceContext
	private EntityManager em;
	
	public FacadeMessagerie() {}
	
	public void ajouterMessage(Compte compte, String text, Compte compteDestinataire, String objet, Date datePub) {
		MessagePrive mp = new MessagePrive(compte, text, compteDestinataire, objet, datePub);
		em.persist(mp);
	}
	
	public Collection<MessagePrive> getMessagesPrivesRecus(Compte compte) {
		return compte.getMpRecus();
	}
	
	public Collection<MessagePrive> getMessagesPrivesEnvoyes(Compte compte) {
		return compte.getMpEnvoyes();
	}
	
}
