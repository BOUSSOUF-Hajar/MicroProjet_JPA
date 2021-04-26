package gi4.javaEE.microProjet_JPA.entity;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Commande {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numCommande;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="codeClient")
	private Client clt;
	private Date dateCommande;
	
	private Set<LignesCommande> lignesCmd = new HashSet<LignesCommande>();
	  
	
	public Commande() {
		super();
	}
	
	public Commande(int numCommande, Client clt, Date dateCommande) {
		super();
		this.numCommande = numCommande;
		this.clt = clt;
		this.dateCommande = dateCommande;
	}

	public int getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}
	
	public Client getClt() {
		return clt;
	}

	public void setClt(Client clt) {
		this.clt = clt;
	}

	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
   @OneToMany(mappedBy = "commande")
	public Set<LignesCommande> getLignesCmd() {
		return lignesCmd;
	}

	public void setLignesCmd(Set<LignesCommande> lignesCmd) {
		this.lignesCmd = lignesCmd;
	}

	@Override
	public String toString() {
		return "Commande [numCommande=" + numCommande + ", clt=" + clt + ", dateCommande=" + dateCommande + "]";
	}
	
	
}
