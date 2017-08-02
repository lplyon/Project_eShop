package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitDao extends IGeneriqueDao<Produit>{
	
	public List<Produit> consulterParCategorie(Long idCategorie);
	
	public List<Produit> consulterSelection(Long idClient);
	
	public List<Produit> consulterParMotClef(String designation);
	
	

}
