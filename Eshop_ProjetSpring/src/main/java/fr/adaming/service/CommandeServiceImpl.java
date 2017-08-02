package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Commande;

public class CommandeServiceImpl implements IGeneriqueDao<Commande>{

	private IGeneriqueDao<Commande> commandeDao;
	

	public void setCommandeDao(IGeneriqueDao<Commande> commandeDao) {
		this.commandeDao = commandeDao;
	}
	

	@Override
	public void ajouter(Commande t) {
		commandeDao.ajouter(t);	
	}

	@Override
	public List<Commande> consulterTout() {
		return commandeDao.consulterTout();
	}

	@Override
	public Commande consulterParId(int id) {
		return commandeDao.consulterParId(id);
	}

	@Override
	public void modifier(Commande t) {
		commandeDao.modifier(t);
	}

	@Override
	public void supprimer(int id) {
		commandeDao.supprimer(id);
	}

}
