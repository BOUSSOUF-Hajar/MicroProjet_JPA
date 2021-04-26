package gi4.javaEE.microProjet_JPA.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="client")
public class Client {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_clt;
	private String nom;
	private String prenom;
	private String email;
	private String modePasse;
	private String adresse;
	private String codePostal;
	private String ville;
	private double tel;
	
	@OneToMany (mappedBy = "clt")
	private List<Commande> cmdsList;
	
	public Client() {
		super();
	}
	
	public Client(int id_clt, String nom, String prenom, String email, String modePasse, String adresse,
			String codePostal, String ville, double tel, List<Commande> cmdsList) {
		super();
		this.id_clt = id_clt;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.modePasse = modePasse;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.tel = tel;
		this.cmdsList = cmdsList;
	}

	public int getId_clt() {
		return id_clt;
	}
	public void setId_clt(int id_clt) {
		this.id_clt = id_clt;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getModePasse() {
		return modePasse;
	}
	public void setModePasse(String modePasse) {
		this.modePasse = modePasse;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public double getTel() {
		return tel;
	}
	public void setTel(double tel) {
		this.tel = tel;
	}
	
	public List<Commande> getCmdsList() {
		return cmdsList;
	}
	public void setCmdsList(List<Commande> cmdsList) {
		this.cmdsList = cmdsList;
	}
	@Override
	public String toString() {
		return "Client [id_clt=" + id_clt + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", modePasse="
				+ modePasse + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", tel="
				+ tel + ", cmdsList=" + cmdsList + "]";
	}
	
	
	
	

}
