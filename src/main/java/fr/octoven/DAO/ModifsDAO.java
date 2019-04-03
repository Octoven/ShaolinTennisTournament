package fr.octoven.DAO;

import java.util.List;

public interface ModifsDAO <E, T> {
	
	public void creer (T t);
	
	public  List<E> lireTable ();
	
	public E find(int i);
	
	public void modifier (T t);
	
	public void supprimer (T t);

}
