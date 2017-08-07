package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe model Produit
 * @author Semi-Croustillant
 *
 */
@Entity
@Table(name = "produits")
public class Produit {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean selectionne;
	private String photo;

	@ManyToOne
	@JoinColumn(name = "fk_categorie", referencedColumnName = "idCategorie")
	private Categorie categorie;

	@OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
	private List<LigneCommande> lLignesCommandes;

	/**
	 * Constructeur non-parametrique
	 */
	public Produit() {
		super();
	}

	/**
	 * Constructeur avec ID
	 * @param idProduit
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selectionne
	 * @param photo
	 */
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

	/**
	 * Constructeur sans ID
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selectionne
	 * @param photo
	 */
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

	// GETTER - SETTER

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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<LigneCommande> getlLignesCommandes() {
		return lLignesCommandes;
	}

	public void setlLignesCommandes(List<LigneCommande> lLignesCommandes) {
		this.lLignesCommandes = lLignesCommandes;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Produit [" + (idProduit != null ? "idProduit=" + idProduit + ", " : "")
				+ (designation != null ? "designation=" + designation + ", " : "")
				+ (description != null ? "description=" + description + ", " : "") + "prix=" + prix + ", quantite="
				+ quantite + ", selectionne=" + selectionne + ", " + (photo != null ? "photo=" + photo + ", " : "")
				+ (categorie != null ? "categorie=" + categorie + ", " : "")
				+ (lLignesCommandes != null ? "lLignesCommandes=" + lLignesCommandes : "") + "]";
	}

}
