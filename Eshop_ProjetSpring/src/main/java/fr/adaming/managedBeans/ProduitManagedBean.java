package fr.adaming.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Produit;
import fr.adaming.service.IGeneriqueService;

@ManagedBean(name="produitMB")
@RequestScoped
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
	//méthode exécutée après instaciation du managed bean
	@PostConstruct
	public void init(){
		this.lProduits=produitService.consulterTout();
		
	}

	//setter pour injection de dépendances
	public void setProduitService(IGeneriqueService<Produit> produitService) {
		this.produitService = produitService;
	}

		//getters et setters
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

	//méthodes services
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
