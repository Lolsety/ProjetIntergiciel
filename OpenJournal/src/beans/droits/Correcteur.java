package beans.droits;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import beans.texte.Article;

public class Correcteur extends Moderateur {
	
	public static Article corrigerArticle(Article article){
	  return null;
	}
	public static Collection<Article> getArticlesAttente(){
		return null;
	}
	public static void SoumettreArticleCorrige(Article article){
		
	}

}
