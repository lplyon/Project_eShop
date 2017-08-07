package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Commande;

/**
 * Class dao Commande
 * @author Semi-Croustillant
 *
 */
@Repository
public class CommandeDaoImpl implements IGeneriqueDao<Commande> {

	// Declaration de la SessionFactory
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * ajoute une commande à la base de donnée
	 * @param commande
	 */
	@Override
	public void ajouter(Commande commande) {
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.save(commande);

	}

	/**
	 * retourne la listes des Commande de base de donnée
	 */
	@Override
	public List<Commande> consulterTout() {// Ouverture de la session (bus) avec
											// la DB
		Session s = sf.getCurrentSession();

		// Requete HQL
		String req = "FROM Commande";

		// Envoie de la requete et récupération du résultat
		Query query = s.createQuery(req);
		List<Commande> lCommandes = query.list();

		return lCommandes;
	}

	/**
	 * Retourne une Commande par son ID
	 * @param id
	 */
	@Override
	public Commande consulterParId(Long id) {
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Commande commande = (Commande) s.get(Commande.class, id);

		return commande;
	}

	/**
	 * modifie une commande dans la base de donnée
	 * @param commande
	 */
	@Override
	public void modifier(Commande commande) {
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(commande);

	}

	/**
	 * supprimer une Commande à l'aide de son id
	 * @param id
	 */
	@Override
	public void supprimer(Long id) {
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Commande command = consulterParId(id);

		s.delete(command);

	}

}
