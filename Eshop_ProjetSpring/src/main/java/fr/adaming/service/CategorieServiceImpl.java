package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Categorie;

public class CategorieServiceImpl implements IGeneriqueService<Categorie> {

	private IGeneriqueDao<Categorie> categorieDao;

	public void setCategorieDao(IGeneriqueDao<Categorie> categorieDao) {
		this.categorieDao = categorieDao;
	}

	@Override
	public void ajouter(Categorie t) {
		categorieDao.ajouter(t);

	}

	@Override
	public List<Categorie> consulterTout() {
		return categorieDao.consulterTout();
	}

	@Override
	public Categorie consulterParId(int id) {
		return categorieDao.consulterParId(id);
	}

	@Override
	public void modifier(Categorie t) {
		categorieDao.modifier(t);
	}

	@Override
	public void supprimer(int id) {
		categorieDao.supprimer(id);
	}

}
