package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "pMB")
@RequestScoped
public class ProduitManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Attributs de la vue
	private Produit produit;
	private List<Produit> lProduits;

	@ManagedProperty(value = "#{produitServiceBean}")
	private IProduitService produitService;

	public ProduitManagedBean() {
		super();
		this.produit = new Produit();
	}

	public void init() {
		this.lProduits = produitService.consulterTout();
	}

	// Les Getters Setters
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Produit> getlProduits() {
		return lProduits;
	}

	public void setlProduits(List<Produit> lProduits) {
		this.lProduits = lProduits;
	}
	
	// Methodes Metiers
	public String ajouterProduit(){
		produitService.ajouter(this.produit);
		
		//Rechargement de la liste
		this.lProduits = produitService.consulterTout();
		return "gestionProduits";
		
	}

}
