package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

/**
 * Class dao Produit
 * @author Semi-Croustillant
 *
 */
@Repository
public class ProduitDaoImpl implements IProduitDao {

	// Appel Dao utiles
	IGeneriqueDao<Categorie> categorieDao;
	IGeneriqueDao<Client> clientDao;
	Categorie categorie;

	// Declaration de la SessionFactory
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * ajoute un produit à la base de donnée
	 * @param produit
	 */
	@Override
	public void ajouter(Produit produit) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.save(produit);

	}

	/**
	 * retourne la listes des produits de base de donnée
	 */
	@Override
	public List<Produit> consulterTout() {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		// Requete HQL
		String req = "FROM Produit";

		// Envoie de la requete et récupération du résultat
		Query query = s.createQuery(req);
		List<Produit> lProduits = query.list();

		return lProduits;
	}

	/**
	 * Retourne un produit par son ID
	 * @param id
	 */
	@Override
	public Produit consulterParId(Long id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Produit produit = (Produit) s.get(Produit.class, id);

		return produit;
	}

	/**
	 * modifie un produit dans la base de donnée
	 * @param produit
	 */
	@Override
	public void modifier(Produit produit) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(produit);

	}

	/**
	 * supprimer un produit à l'aide de son id
	 * @param id
	 */
	@Override
	public void supprimer(Long id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Produit produit = consulterParId(id);
		s.delete(produit);

	}

	// Methodes Metiers

	/**
	 * Methode métier
	 * permet d'obtenir la liste des produit d'une catégorie
	 * @param idCategorie
	 */
	@Override
	public List<Produit> consulterParCategorie(Long idCategorie) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		String req = "FROM Produit p WHERE p.categorie.idCategorie=?";
		Query query = s.createQuery(req);
		query.setParameter(1, categorie.getIdCategorie());
		List<Produit> lProduit = query.list();

		return lProduit;
	}


	@Override
	public List<Produit> consulterSelection(Long idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Methode métier
	 * Permet d'obtenir les produits par designation partiel
	 * @param designation
	 */
	@Override
	public List<Produit> consulterParMotClef(String designation) {
		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		String req = "FROM Produit p WHERE p.designation like %?%";
		Query query = s.createQuery(req);
		query.setParameter(1, designation);
		List<Produit> lProduits = query.list();
		return lProduits;
	}

}
