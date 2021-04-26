package gi4.javaEE.microProjet_JPA.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String refCat;
	
	private String cat;
	@OneToMany
	private List<Article> articles;
	
	public Categorie() {
		super();
	}
	public Categorie(String refCat, String cat) {
		super();
		this.refCat = refCat;
		this.cat = cat;
	}
	public String getRefCat() {
		return refCat;
	}
	public void setRefCat(String refCat) {
		this.refCat = refCat;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Categorie [refCat=" + refCat + ", cat=" + cat + "]";
	}
	
	
}
