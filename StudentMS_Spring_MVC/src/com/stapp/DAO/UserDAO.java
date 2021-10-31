package com.stapp.DAO;

public interface UserDAO<T,I> {
	
	public T save(I user);
	public T update(I user);
	public I searchById(T id);
	public I searchByName(String name);
	public T deleteUser(I user);
	
}
