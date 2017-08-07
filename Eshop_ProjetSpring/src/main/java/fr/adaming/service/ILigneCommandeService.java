package fr.adaming.service;

import java.util.List;

import fr.adaming.model.LigneCommande;

/**
 * Interface Service LigneCommande
 * @author Semi-Croustillant
 *
 */
public interface ILigneCommandeService {
	
	public void ajouter(LigneCommande ligneCommande);

	public List<LigneCommande> consulterTout();

	public LigneCommande consulterParId(int id);

	public void modifier(LigneCommande ligneCommande);

	public void supprimer(int id);


}
