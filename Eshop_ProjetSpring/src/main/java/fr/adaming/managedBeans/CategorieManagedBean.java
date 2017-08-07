package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.Categorie;
import fr.adaming.service.IGeneriqueService;

@ManagedBean(name = "categorieMB")
@ViewScoped
public class CategorieManagedBean implements Serializable {

	// attributs
	private Categorie categorie;
	private List<Categorie> lCategories;

	@ManagedProperty(value = "#{categorieServiceBean}")
	private IGeneriqueService<Categorie> categorieService;

	public CategorieManagedBean() {
		super();
		this.categorie = new Categorie();
	}

	// Setter pour injection de dépendances
	public void setCategorieService(IGeneriqueService<Categorie> categorieService) {
		this.categorieService = categorieService;
	}
	
	//Méthode exécutée après instanciation du managed bean
	@PostConstruct
	public void init(){
		this.lCategories = categorieService.consulterTout();
	}
	
	
	// getters et setters
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Categorie> getlCategories() {
		return lCategories;
	}

	public void setlCategories(List<Categorie> lCategories) {
		this.lCategories = lCategories;
	}

	//méthodes services
	public String ajouterCategorie() {
		categorieService.ajouter(this.categorie);
		this.lCategories = categorieService.consulterTout();
		return "listeCategorie";
	}

	public String modifierCategorie() {
		categorieService.modifier(this.categorie);
		this.lCategories = categorieService.consulterTout();
		return "listeCategorie";
	}

	public String supprimerCategorie() {
		categorieService.supprimer(this.categorie.getIdCategorie());
		this.lCategories = categorieService.consulterTout();
		return "listeCategorie";
	}

	public String rechercherCategorie() {
		this.categorie=categorieService.consulterParId(this.categorie.getIdCategorie());
		return "rechercheCategorie";
	}

}
