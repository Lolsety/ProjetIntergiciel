package droits;

import java.util.Collection;
//@Singleton
public class Administrateur extends Correcteur implements Droit {

	public Collection<texte.Article> getArticlesAttenteCorrigés(){
		return null;
	}
	public void publierArticle(texte.Article article){
		
	}
	public void donnerDroit(compte.Compte compte,droits.Droit droit){
		compte.setDroit(droit);
	}
}
