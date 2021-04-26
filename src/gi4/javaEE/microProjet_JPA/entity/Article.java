package gi4.javaEE.microProjet_JPA.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Article {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codeArticle;
	private String designation;
	private String prix;
	private String stock;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categ")
	private Categorie categorie;
	private String photo;
	
	private Set<LignesCommande> lignesCmd = new HashSet<LignesCommande>();
	
	public Article() {
		super();
	}
	
	public Article(int codeArticle, String designation, String prix, String stock, Categorie categorie, String photo) {
		super();
		this.codeArticle = codeArticle;
		this.designation = designation;
		this.prix = prix;
		this.stock = stock;
		this.categorie = categorie;
		this.photo = photo;
	}

	public int getCodeArticle() {
		return codeArticle;
	}
	public void setCodeArticle(int codeArticle) {
		this.codeArticle = codeArticle;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@OneToMany(mappedBy = "article")
	public Set<LignesCommande> getLignesCmd() {
		return lignesCmd;
	}

	public void setLignesCmd(Set<LignesCommande> lignesCmd) {
		this.lignesCmd = lignesCmd;
	}

	@Override
	public String toString() {
		return "Article [codeArticle=" + codeArticle + ", designation=" + designation + ", prix=" + prix + ", stock="
				+ stock + ", categorie=" + categorie + ", photo=" + photo + "]";
	}
	
	
}
