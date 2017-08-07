package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.LigneCommande;

/**
 * Class dao LigneCommande
 * @author Semi-Croustillant
 *
 */
@Repository
public class LigneCommandeDaoImpl implements ILigneCommandeDao {

	// Declaration de la SessionFactory
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * ajoute une ligneCommande à la base de donnée
	 * @param ligneCommande
	 */
	@Override
	public void ajouter(LigneCommande ligneCommande) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.save(ligneCommande);

	}

	/**
	 * retourne la listes des ligneCommande de base de donnée
	 */
	@Override
	public List<LigneCommande> consulterTout() {
		
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		// Requete HQL
		String req = "FROM LigneCommande";

		// Envoi de la requete et récupération du résultat
		Query query = s.createQuery(req);
		List<LigneCommande> lLigneCommandes = query.list();

		return lLigneCommandes;
	}

	/**
	 * Retourne une ligneCommande par son ID
	 * @param id
	 */
	@Override
	public LigneCommande consulterParId(int id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		LigneCommande ligneCommande = (LigneCommande) s.get(LigneCommande.class, id);

		return ligneCommande;
	}

	/**
	 * modifie une ligneCommande dans la base de donnée
	 * @param ligneCommande
	 */
	@Override
	public void modifier(LigneCommande ligneCommande) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(ligneCommande);

	}

	/**
	 * supprimer un produit à l'aide de son id
	 * @param id
	 */
	@Override
	public void supprimer(int id) {
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		LigneCommande ligneCommande = consulterParId(id);

		s.delete(ligneCommande);
	}

	


}
