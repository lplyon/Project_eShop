package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

@Service("produitServiceBean")
@Transactional
public class ProduitServiceImpl implements IProduitDao{

	@Autowired
	private IProduitDao produitDao;

	
	public void setProduitDao(IProduitDao produitDao) {
		this.produitDao = produitDao;
	}

	@Override
	public void ajouter(Produit t) {
		produitDao.ajouter(t);
	}

	@Override
	public List<Produit> consulterTout() {
		return produitDao.consulterTout();
	}

	@Override
	public Produit consulterParId(int id) {
		return produitDao.consulterParId(id);
	}

	@Override
	public void modifier(Produit t) {
		produitDao.modifier(t);
	}

	@Override
	public void supprimer(int id) {
		produitDao.supprimer(id);
	}

	@Override
	public List<Produit> consulterParCategorie(int idCategorie) {
		return produitDao.consulterParCategorie(idCategorie);
	}

	@Override
	public List<Produit> consulterSelection(int idClient) {
		return produitDao.consulterSelection(idClient);
	}

	@Override
	public List<Produit> consulterParMotClef(String designation) {
		return produitDao.consulterParMotClef(designation);
	}

}
