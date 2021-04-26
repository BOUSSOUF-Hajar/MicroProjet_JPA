package gi4.javaEE.microProjet_JPA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LignesCommande {
	@Id
	private int id;
	private Commande commande;
	private Article article;
	private String qteCommande;
	
	public LignesCommande() {
		super();
	}
	
	public LignesCommande(int id, Commande commande, Article article, String qteCommande) {
		super();
		this.id = id;
		this.commande = commande;
		this.article = article;
		this.qteCommande = qteCommande;
	}

	@ManyToOne()
	@JoinColumn(name = "numCommande")
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	@ManyToOne()
	@JoinColumn(name = "codeArticle")
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getQteCommande() {
		return qteCommande;
	}
	public void setQteCommande(String qteCommande) {
		this.qteCommande = qteCommande;
	}
	@Override
	public String toString() {
		return "LignesCommande [commande=" + commande + ", article=" + article + ", qteCommande=" + qteCommande + "]";
	}
	
	
}
