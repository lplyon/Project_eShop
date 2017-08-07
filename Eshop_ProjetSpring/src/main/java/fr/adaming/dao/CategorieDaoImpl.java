package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

/**
 * Class dao Categorie
 * @author Semi-Croustillant
 *
 */
@Repository
public class CategorieDaoImpl implements IGeneriqueDao<Categorie> {

	// Declaration de la SessionFactory
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * ajoute une Categorie à la base de donnée
	 * @param client
	 */
	@Override
	public void ajouter(Categorie categorie) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.save(categorie);
	}

	/**
	 * retourne la liste des Categorie de base de donnée
	 */
	@Override
	public List<Categorie> consulterTout() {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		// Requete HQL
		String req = "FROM Categorie";

		// Envoie de la requete et récupération du résultat
		Query query = s.createQuery(req);
		List<Categorie> lCategories = query.list();

		return lCategories;
	}

	/**
	 * Retourne une Categorie par son ID
	 * @param id
	 */
	@Override
	public Categorie consulterParId(Long id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Categorie categorie = (Categorie) s.get(Categorie.class, id);

		return categorie;
	}

	/**
	 * modifie une Categorie dans la base de donnée
	 * @param categorie
	 */
	@Override
	public void modifier(Categorie categorie) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(categorie);
	}

	/**
	 * supprimer un Categorie à l'aide de son id
	 * @param id
	 */
	@Override
	public void supprimer(Long id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();
		Categorie categorie = consulterParId(id);

		s.delete(categorie);

	}

}
