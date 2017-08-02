package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitDao extends IGeneriqueDao<Produit>{
	
	public List<Produit> consulterParCategorie(int idCategorie);
	
	public List<Produit> consulterSelection(int idClient);
	
	public List<Produit> consulterParMotClef(String designation);
	
	

}
