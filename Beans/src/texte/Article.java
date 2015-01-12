package texte;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Article extends Texte {
	private final String URL = "";
	private int id;
	String titre;
	
	public Article(compte.Compte compte, int datePub, String titre,int id){
		this.id =id;
		this.auteur = compte;
		this.text = URL + Integer.toString(this.id)+ ".txt";
		this.datePub = datePub;
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getContenu() {
		 String article="";
		 int c;
		 try {
			 final FileReader reader = new FileReader(this.text);
			 try {
				 while ((c = reader.read()) != -1) {
					 article = article + (char)c;
				 }
			 } finally {
				 // quoiqu'il arrive, on ferme le fichier
				 reader.close();
			 }
		 } catch (Exception e) {
	            System.out.println("Impossible de lire le fichier");
	      }
		return article;
	}
	
	public void setContenu(String text) {	
		final File fichier =new File(this.text);
		try {
			// Creation du fichier
		       	fichier.createNewFile();
	
			final FileWriter writer = new FileWriter(fichier);
			try {
				writer.write(text);
			} finally {
	           // quoiqu'il arrive, on ferme le fichier
	           writer.close();
			}
	    } catch (Exception e) {
		   e.printStackTrace();
	       System.out.println("Impossible de modifier le fichier");
	   }
		
	}
}
