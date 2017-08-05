package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.LigneCommande;

public interface ILigneCommandeDao {
	public void ajouter(LigneCommande ligneCommande);

	public List<LigneCommande> consulterTout();

	public LigneCommande consulterParId(int id);

	public void modifier(LigneCommande ligneCommande);

	public void supprimer(int id);

}
