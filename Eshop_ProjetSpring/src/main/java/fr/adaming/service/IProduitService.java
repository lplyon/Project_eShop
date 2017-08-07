package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

/**
 * Interface Service Produit qui �tand l'Interface g�n�rique
 * @author Semi-Croustillant
 *
 */
public interface IProduitService extends IGeneriqueService<Produit>{
	
	/**
	 * Methode m�tier pour consulter une liste de produit par cat�gorie
	 * @param idCategorie
	 * @return List<Produit>
	 */
	public List<Produit> consulterParCategorie(Long idCategorie);
	
	/**
	 * Methode m�tier pour consulter une liste de produit par Client
	 * @param idClient
	 * @return List<Produit>
	 */
	public List<Produit> consulterSelection(Long idClient);
	
	/**
	 * Methode m�tier pour consulter une liste de produit par designation
	 * @param designation
	 * @return List<Produit>
	 */
	public List<Produit> consulterParMotClef(String designation);

}
