package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Commande;

@Service("commandServiceBean")
@Transactional
public class CommandeServiceImpl implements IGeneriqueDao<Commande>{

	@Autowired
	private IGeneriqueDao<Commande> commandeDao;
	

	public void setCommandeDao(IGeneriqueDao<Commande> commandeDao) {
		this.commandeDao = commandeDao;
	}
	

	@Override
	public void ajouter(Commande commande) {
		commandeDao.ajouter(commande);	
	}

	@Override
	public List<Commande> consulterTout() {
		return commandeDao.consulterTout();
	}

	@Override
	public Commande consulterParId(Long id) {
		return commandeDao.consulterParId(id);
	}

	@Override
	public void modifier(Commande commande) {
		commandeDao.modifier(commande);
	}

	@Override
	public void supprimer(Long id) {
		commandeDao.supprimer(id);
	}

}
