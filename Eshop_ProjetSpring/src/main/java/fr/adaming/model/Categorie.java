package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categorie {

	// les attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	private String nomCategorie;
	private byte photo;
	private String description;
	
	@OneToMany(mappedBy="categorie", cascade=CascadeType.ALL)
	private List<Produit> lProduits;

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(Long idCategorie, String nomCategorie, byte photo, String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}

	public Categorie(String nomCategorie, byte photo, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}

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

	public byte getPhoto() {
		return photo;
	}

	public void setPhoto(byte photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Categorie [" + (idCategorie != null ? "idCategorie=" + idCategorie + ", " : "")
				+ (nomCategorie != null ? "nomCategorie=" + nomCategorie + ", " : "") + "photo=" + photo + ", "
				+ (description != null ? "description=" + description : "") + "]";
	}

}
