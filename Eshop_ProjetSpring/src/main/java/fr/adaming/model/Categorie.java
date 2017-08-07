package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Semi-Croustillant
 *
 */
@Entity
@Table(name = "categories")
public class Categorie {

	// les attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	private String nomCategorie;
	private String description;

	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private List<Produit> lProduits;

	/**
	 * Constructeur non-parametrique
	 */
	public Categorie() {
		super();
	}

	/**
	 * Constructeur avec ID
	 * 
	 * @param idCategorie
	 * @param nomCategorie
	 * @param description
	 */
	public Categorie(Long idCategorie, String nomCategorie, String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;

		this.description = description;
	}

	/**
	 * Constructeur sans ID
	 * 
	 * @param nomCategorie
	 * @param description
	 */
	public Categorie(String nomCategorie, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
	}

	// GETTER - SETTER

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Produit> getlProduits() {
		return lProduits;
	}

	public void setlProduits(List<Produit> lProduits) {
		this.lProduits = lProduits;
	}

	@Override
	public String toString() {
		return "Categorie [" + (idCategorie != null ? "idCategorie=" + idCategorie + ", " : "")
				+ (nomCategorie != null ? "nomCategorie=" + nomCategorie + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (lProduits != null ? "lProduits=" + lProduits : "") + "]";
	}

	// TO STRING

}
