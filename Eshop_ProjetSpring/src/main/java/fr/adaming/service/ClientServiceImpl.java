package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Client;

public class ClientServiceImpl implements IGeneriqueService<Client> {

	private IGeneriqueDao<Client> clientDao;

	// le SETTER
	public void setClientDao(IGeneriqueDao<Client> clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public void ajouter(Client t) {
		clientDao.ajouter(t);
	}

	@Override
	public List<Client> consulterTout() {
		return clientDao.consulterTout();
	}

	@Override
	public Client consulterParId(int id) {
		return clientDao.consulterParId(id);
	}

	@Override
	public void modifier(Client t) {
		clientDao.modifier(t);

	}

	@Override
	public void supprimer(int id) {
		clientDao.supprimer(id);

	}

}
