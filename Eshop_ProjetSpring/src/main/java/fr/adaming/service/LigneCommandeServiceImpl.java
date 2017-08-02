package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.LigneCommande;

@Service("ligneCommandeServiceBean")
@Transactional
public class LigneCommandeServiceImpl implements IGeneriqueService<LigneCommande> {

	@Autowired
	private IGeneriqueDao<LigneCommande> ligneCommandeDao;

	@Override
	public void ajouter(LigneCommande ligneCommande) {
		ligneCommandeDao.ajouter(ligneCommande);

	}

	@Override
	public List<LigneCommande> consulterTout() {

		return ligneCommandeDao.consulterTout();
	}

	@Override
	public LigneCommande consulterParId(int id) {

		return ligneCommandeDao.consulterParId(id);
	}

	@Override
	public void modifier(LigneCommande ligneCommande) {
		ligneCommandeDao.modifier(ligneCommande);

	}

	@Override
	public void supprimer(int id) {
		ligneCommandeDao.supprimer(id);

	}

}
