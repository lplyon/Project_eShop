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

	// Methodes CRUD

	@Override
	public void ajouter(Produit produit) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.save(produit);

	}

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

	@Override
	public Produit consulterParId(int id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Produit produit = (Produit) s.get(Produit.class, id);

		return produit;
	}

	@Override
	public void modifier(Produit produit) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(produit);

	}

	@Override
	public void supprimer(int id) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		Produit produit = consulterParId(id);
		s.delete(produit);

	}

	// Methodes Metiers

	@Override
	public List<Produit> consulterParCategorie(int idCategorie) {

		// Ouverture de la session (bus) avec la DB
		Session s = sf.getCurrentSession();

		String req = "FROM Produit p WHERE p.categorie.idCategorie=?";
		Query query = s.createQuery(req);
		query.setParameter(1, categorie.getIdCategorie());
		List<Produit> lProduit = query.list();

		return lProduit;
	}

	@Override
	public List<Produit> consulterSelection(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

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
