package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.Commande;
import fr.adaming.service.IGeneriqueService;

@ManagedBean(name="commandeMB")
@ViewScoped
public class CommandeManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private Commande commande;
	private List<Commande> lCommandes;
	
	
	@ManagedProperty("commandServiceBean")
	private IGeneriqueService<Commande> comService;
	
	public CommandeManagedBean() {
		super();
		this.commande=new Commande();
	}
	
	//setter pour injection de dépendances
	public void setComService(IGeneriqueService<Commande> comService) {
		this.comService = comService;
	}
	
	//méthode exécutée après instanciation du managed bean
	@PostConstruct
	public void init(){	
		this.lCommandes=comService.consulterTout();
	}
	
	//getters et setters
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<Commande> getlCommandes() {
		return lCommandes;
	}

	public void setlCommandes(List<Commande> lCommandes) {
		this.lCommandes = lCommandes;
	}

	
	//méthodes services
	public String ajouterCommande(){
		comService.ajouter(this.commande);
		this.lCommandes=comService.consulterTout();
		return"listeCommande";
	}
	
	public String modifierCommande(){
		comService.modifier(this.commande);
		this.lCommandes=comService.consulterTout();
		return"listeCommande";
	}
	
	public String supprimerCommande(){
		comService.supprimer(this.commande.getIdCommande());
		this.lCommandes=comService.consulterTout();
		return"listeCommande";
	}
	
	public String rechercherCommande(){
		this.commande=comService.consulterParId(this.commande.getIdCommande());
		this.lCommandes=comService.consulterTout();
		return"listeCommande";
	}

}
