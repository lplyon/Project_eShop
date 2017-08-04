package fr.adaming.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import fr.adaming.model.Produit;
import fr.adaming.service.IGeneriqueService;

public class ProduitManagedBean {
	//attributs
	private Produit produit;
	private List<Produit>lProduits;
	
	@ManagedProperty(value="#{produitServiceBean}")
	private IGeneriqueService<Produit> produitService;
	
	
	
	public ProduitManagedBean() {
		super();
		this.produit=new Produit();
	}
	
	@PostConstruct
	public void init(){
		this.lProduits=produitService.consulterTout();
		
	}

	public void setProduitService(IGeneriqueService<Produit> produitService) {
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

	
	public String ajouterProduit(){
		produitService.ajouter(this.produit);
		this.lProduits=produitService.consulterTout();
		return "listeProduits";
	}
	
	public String modifierProduit(){
		produitService.modifier(this.produit);
		this.lProduits=produitService.consulterTout();
		return "listeProduits";
	}
	
	public String supprimerProduit(){
		produitService.supprimer(this.produit.getIdProduit());
		this.lProduits=produitService.consulterTout();
		return "listeProduits";
	}
	
	public String rechercherProduit(){
		produitService.consulterParId(this.produit.getIdProduit());
		this.lProduits=produitService.consulterTout();
		return "rechercheProduits";
	}
	
}
