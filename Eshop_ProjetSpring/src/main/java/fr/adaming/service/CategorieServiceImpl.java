package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Categorie;

@Service("categorieServiceBean")
@Transactional
public class CategorieServiceImpl implements IGeneriqueService<Categorie> {

	@Autowired
	private IGeneriqueDao<Categorie> categorieDao;

	public void setCategorieDao(IGeneriqueDao<Categorie> categorieDao) {
		this.categorieDao = categorieDao;
	}

	@Override
	public void ajouter(Categorie categorie) {
		categorieDao.ajouter(categorie);

	}

	@Override
	public List<Categorie> consulterTout() {
		return categorieDao.consulterTout();
	}

	@Override
	public Categorie consulterParId(Long id) {
		return categorieDao.consulterParId(id);
	}

	@Override
	public void modifier(Categorie categorie) {
		categorieDao.modifier(categorie);
	}

	@Override
	public void supprimer(Long id) {
		categorieDao.supprimer(id);
	}

}
