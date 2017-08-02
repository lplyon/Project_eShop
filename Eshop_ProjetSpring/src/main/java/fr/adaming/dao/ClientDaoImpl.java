package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IGeneriqueDao<Client> {

	// Declaration de la SessionFactory
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void ajouter(Client client) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.save(client);

	}

	@Override
	public List<Client> consulterTout() {
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		// Requete HQL
		String req = "FROM Client";

		// Envoie de la requete et récupération du résultat
		Query query = s.createQuery(req);
		List<Client> lClients = query.list();

		return lClients;
	}

	@Override
	public Client consulterParId(int id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Client client = (Client) s.get(Client.class, id);

		return client;
	}

	@Override
	public void modifier(Client client) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(client);

	}

	@Override
	public void supprimer(int id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Client client = consulterParId(id);
		s.delete(client);

	}

}
