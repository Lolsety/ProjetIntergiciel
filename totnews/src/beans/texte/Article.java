package beans.texte;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import beans.comptes.Compte;

//@Stateful
@Entity
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Compte auteur;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "article")
	Collection<Commentaire> commentaires;
	
	private Date datePub;
	private String text;
	
	
	private final String URL = "C:\\Users\\Tom\\Desktop\\ENSEEIHT\\Intergiciel\\db\\articles\\";
	private String titre;
	private  boolean publicationAutorise;

	private Date dateModif;
	

	public Article() {}
	
	public Article(Compte compte, Date datePub, String titre){
		this.auteur = compte;
		this.datePub = datePub;
		this.titre = titre;
		this.publicationAutorise = false;
		this.dateModif = null;
	}

	public Compte getAuteur() {
		return auteur;
	}
	public void setAuteur(Compte auteur) {
		this.auteur = auteur;
	}
	public Date getDatePub() {
		return datePub;
	}
	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getDateModif() {
		return dateModif;
	}
	
	public boolean isPublicationAutorise() {
		return publicationAutorise;
	}

	public void setPublicationAutorise(boolean publicationAutorise) {
		this.publicationAutorise = publicationAutorise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	            System.out.println("Impossible de lire le fichier : " + this.text);
	      }
		return article;
	}
	
	public void setContenu(String text) {	
		this.text = URL + Integer.toString(this.id)+ ".txt";
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

	public String getURL() {
		return URL;
	}

	public void setDateModif(Date date) {
		// TODO Auto-generated method stub
		this.dateModif = date;
	}

	public Date getDatePub() {
		return datePub;
	}

	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}
	
}