package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

@Repository
public class CategorieDaoImpl implements IGeneriqueDao<Categorie> {

	// Declaration de la SessionFactory
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void ajouter(Categorie categorie) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.save(categorie);
	}

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

	@Override
	public Categorie consulterParId(int id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Categorie categorie = (Categorie) s.get(Categorie.class, id);

		return categorie;
	}

	@Override
	public void modifier(Categorie categorie) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(categorie);
	}

	@Override
	public void supprimer(int id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();
		Categorie categorie = consulterParId(id);

		s.delete(categorie);

	}

}
