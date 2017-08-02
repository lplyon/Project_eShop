package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService extends IGeneriqueService<Produit>{
	
	public List<Produit> consulterParCategorie(int idCategorie);
	
	public List<Produit> consulterSelection(int idClient);
	
	public List<Produit> consulterParMotClef(String designation);

}
