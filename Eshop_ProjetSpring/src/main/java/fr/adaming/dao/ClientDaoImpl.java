package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

/**
 * Class dao Client
 * @author Semi-Croustillant
 *
 */
@Repository
public class ClientDaoImpl implements IGeneriqueDao<Client> {

	// Declaration de la SessionFactory
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * ajoute un Client à la base de donnée
	 * @param client
	 */
	@Override
	public void ajouter(Client client) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.save(client);

	}

	/**
	 * retourne la liste des Clients de base de donnée
	 */
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

	/**
	 * Retourne un Client par son ID
	 * @param id
	 */
	@Override
	public Client consulterParId(Long id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Client client = (Client) s.get(Client.class, id);

		return client;
	}

	/**
	 * modifie un Client dans la base de donnée
	 * @param ligneCommande
	 */
	@Override
	public void modifier(Client client) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(client);

	}

	/**
	 * supprimer un Client à l'aide de son id
	 * @param id
	 */
	@Override
	public void supprimer(Long id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Client client = consulterParId(id);
		s.delete(client);

	}

}
