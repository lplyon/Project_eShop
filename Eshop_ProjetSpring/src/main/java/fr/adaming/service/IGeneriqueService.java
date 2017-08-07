package fr.adaming.service;

import java.util.List;

/**
 * Interface Service Générique
 * 
 * @author Semi-Croustillant
 *
 * @param <T>
 */
public interface IGeneriqueService<T> {

	/**
	 * Methode d'ajout. Fait appel à la methode ajouter de la dao
	 * 
	 * @param t
	 */
	public void ajouter(T t);

	/**
	 * Methode de consultation de la liste d'entité. Fait appel à la methode
	 * consultation de la dao retourne la liste
	 * 
	 * @param t
	 */
	public List<T> consulterTout();

	/**
	 * Methode de consultation par ID. Fait appel à la methode de la dao
	 * 
	 * @param t
	 */
	public T consulterParId(Long id);

	/**
	 * Methode de modification. Fait appel à la methode modifier de la dao
	 * 
	 * @param t
	 */
	public void modifier(T t);

	/**
	 * Methode de suppression. Fait appel à la methode supprimer de la dao
	 * 
	 * @param t
	 */
	public void supprimer(Long id);

}
