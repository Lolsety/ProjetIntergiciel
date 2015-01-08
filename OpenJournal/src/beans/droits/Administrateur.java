package beans.droits;

import java.util.Collection;

import beans.comptes.Compte;
import beans.texte.Article;

public class Administrateur extends Correcteur {

	public static Collection<Article> getArticlesAttenteCorriges(){
		return null;
	}
	public static void publierArticle(Article article){
		
	}
	public static void donnerDroit(Compte compte,Droit droit){
		compte.setDroit(droit);
	}
}
