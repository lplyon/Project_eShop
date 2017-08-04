package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.adaming.model.Commande;
import fr.adaming.service.IGeneriqueService;

@ManagedBean(name="commandeMB")
public class CommandeManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Commande commande;
	private List<Commande> lCommandes;
	
	@ManagedProperty("commandServiceBean")
	private IGeneriqueService<Commande> comService;
	
	public CommandeManagedBean() {
		super();
		this.commande=new Commande();
	}

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

	public void setComService(IGeneriqueService<Commande> comService) {
		this.comService = comService;
	}
	
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
		comService.consulterParId(this.commande.getIdCommande());
		this.lCommandes=comService.consulterTout();
		return"listeCommande";
	}

}
