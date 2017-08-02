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
	public void ajouter(Client client) {
		clientDao.ajouter(client);
	}

	@Override
	public List<Client> consulterTout() {
		return clientDao.consulterTout();
	}

	@Override
	public Client consulterParId(Long id) {
		return clientDao.consulterParId(id);
	}

	@Override
	public void modifier(Client client) {
		clientDao.modifier(client);

	}

	@Override
	public void supprimer(Long id) {
		clientDao.supprimer(id);

	}

}
