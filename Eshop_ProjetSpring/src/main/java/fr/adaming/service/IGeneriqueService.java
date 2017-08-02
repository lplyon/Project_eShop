package fr.adaming.service;

import java.util.List;

public interface IGeneriqueService<T> {
	
	public void ajouter(T t);

	public List<T> consulterTout();

	public T consulterParId(Long id);

	public void modifier(T t);

	public void supprimer(Long id);

}
