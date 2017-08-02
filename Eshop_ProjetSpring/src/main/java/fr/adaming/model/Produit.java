package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="produits")
public class Produit {

	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	private boolean selectionne;
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "fk_categorie", referencedColumnName = "idCategorie")
	private Categorie categorie;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "JoinTable", joinColumns = @JoinColumn(name = "idcommande"), inverseJoinColumns = @JoinColumn(name = "idProduit"))
	private List<Produit> lproduits;

	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(String designation, String description, double prix, int quantite, boolean selectionne,
			String photo) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
	}

	public Produit(Long idProduit, String designation, String description, double prix, int quantite,
			boolean selectionne, String photo) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
