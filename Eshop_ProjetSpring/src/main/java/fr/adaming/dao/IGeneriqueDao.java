package fr.adaming.dao;

import java.util.List;

public interface IGeneriqueDao<T> {

	public void ajouter(T t);

	public List<T> consulterTout();

	public T consulterParId(Long id);

	public void modifier(T t);

	public void supprimer(Long id);

}
