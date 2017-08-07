package fr.adaming.service;

import java.util.List;

/**
 * Interface Service G�n�rique
 * 
 * @author Semi-Croustillant
 *
 * @param <T>
 */
public interface IGeneriqueService<T> {

	/**
	 * Methode d'ajout. Fait appel � la methode ajouter de la dao
	 * 
	 * @param t
	 */
	public void ajouter(T t);

	/**
	 * Methode de consultation de la liste d'entit�. Fait appel � la methode
	 * consultation de la dao retourne la liste
	 * 
	 * @param t
	 */
	public List<T> consulterTout();

	/**
	 * Methode de consultation par ID. Fait appel � la methode de la dao
	 * 
	 * @param t
	 */
	public T consulterParId(Long id);

	/**
	 * Methode de modification. Fait appel � la methode modifier de la dao
	 * 
	 * @param t
	 */
	public void modifier(T t);

	/**
	 * Methode de suppression. Fait appel � la methode supprimer de la dao
	 * 
	 * @param t
	 */
	public void supprimer(Long id);

}
