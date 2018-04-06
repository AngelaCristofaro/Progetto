package it.ariadne.progetto.dao;


public interface InterfacciaDao <T> {
	public void  insert(T t);
	public void	 delete(T t);
	public void  update(T t);
}
