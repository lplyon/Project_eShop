package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lignesCommandes")
public class LigneCommande {

	// les attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLigneCommande;
	private int quantite;
	private double prix;

	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "LigneCommande [quantite=" + quantite + ", prix=" + prix + "]";
	}

}
