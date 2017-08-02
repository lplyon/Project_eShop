package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Client;

@Service("clientServiceBean")
@Transactional
public class ClientServiceImpl implements IGeneriqueService<Client> {

	@Autowired
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
