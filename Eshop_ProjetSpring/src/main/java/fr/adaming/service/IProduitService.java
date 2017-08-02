package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService extends IGeneriqueService<Produit>{
	
	public List<Produit> consulterParCategorie(Long idCategorie);
	
	public List<Produit> consulterSelection(Long idClient);
	
	public List<Produit> consulterParMotClef(String designation);

}
