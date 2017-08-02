package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.LigneCommande;

@Repository
public class LigneCommandeDaoImpl implements IGeneriqueDao<LigneCommande> {

	// Declaration de la SessionFactory
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void ajouter(LigneCommande ligneCommande) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.save(ligneCommande);

	}

	@Override
	public List<LigneCommande> consulterTout() {
		
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		// Requete HQL
		String req = "FROM LigneCommande";

		// Envoie de la requete et récupération du résultat
		Query query = s.createQuery(req);
		List<LigneCommande> lLigneCommandes = query.list();

		return lLigneCommandes;
	}

	@Override
	public LigneCommande consulterParId(int id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		LigneCommande ligneCommande = (LigneCommande) s.get(LigneCommande.class, id);

		return ligneCommande;
	}

	@Override
	public void modifier(LigneCommande ligneCommande) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(ligneCommande);

	}

	@Override
	public void supprimer(int id) {
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		LigneCommande ligneCommande = consulterParId(id);

		s.delete(ligneCommande);
	}

}
