package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

/**
 * Interface Service Produit qui étand l'Interface générique
 * @author Semi-Croustillant
 *
 */
public interface IProduitService extends IGeneriqueService<Produit>{
	
	/**
	 * Methode métier pour consulter une liste de produit par catégorie
	 * @param idCategorie
	 * @return List<Produit>
	 */
	public List<Produit> consulterParCategorie(Long idCategorie);
	
	/**
	 * Methode métier pour consulter une liste de produit par Client
	 * @param idClient
	 * @return List<Produit>
	 */
	public List<Produit> consulterSelection(Long idClient);
	
	/**
	 * Methode métier pour consulter une liste de produit par designation
	 * @param designation
	 * @return List<Produit>
	 */
	public List<Produit> consulterParMotClef(String designation);

}
