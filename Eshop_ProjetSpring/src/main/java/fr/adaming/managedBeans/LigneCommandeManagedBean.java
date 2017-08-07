package fr.adaming.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.LigneCommande;
import fr.adaming.service.IGeneriqueService;
import fr.adaming.service.ILigneCommandeService;

@ManagedBean(name="ligneCMB")
@ViewScoped
public class LigneCommandeManagedBean {
	
	//attributs
	private LigneCommande ligneCommande;
	private List<LigneCommande> lLigneCdes;
	
	@ManagedProperty(value="ligneCommandeServiceBean")
	private ILigneCommandeService lcService;

	//setter pour injection de dépendances
	public void setLcService(ILigneCommandeService lcService) {
		this.lcService = lcService;
	}
	
	
	
	public LigneCommandeManagedBean() {
		super();
		this.ligneCommande=new LigneCommande();
		}

	//méthode exécutée après intanciation du managed bean
	@PostConstruct
	public void init(){
		this.lLigneCdes=lcService.consulterTout();
	}

	//getters et setters
	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public List<LigneCommande> getlLigneCdes() {
		return lLigneCdes;
	}

	public void setlLigneCdes(List<LigneCommande> lLigneCdes) {
		this.lLigneCdes = lLigneCdes;
	}
	
	//méthodes services
	
	public String ajouterLigneCommande(){
		lcService.ajouter(this.ligneCommande);
		this.lLigneCdes=lcService.consulterTout();
		return"listeLigneCdes";
	}
	
	public String modifierLigneCommande(){
		lcService.modifier(this.ligneCommande);
		this.lLigneCdes=lcService.consulterTout();
		return"listeLigneCdes";
	}
	
	public String supprimerLigneCommande(){
		lcService.supprimer(this.ligneCommande.getIdLigneCommande());
		this.lLigneCdes=lcService.consulterTout();
		return"listeLigneCdes";
	}
	

}
