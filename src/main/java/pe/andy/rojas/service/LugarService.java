package pe.andy.rojas.service;

import java.util.Collection;

import pe.andy.rojas.entity.locaciones;


public interface LugarService {

	public abstract void insert (locaciones locacions);
	public abstract void update (locaciones locacions);
	public abstract void delete (Integer locationId);
	public abstract locaciones findById(Integer locationId);
	public abstract Collection<locaciones> findAll();
	
	public abstract locaciones findByCity(String city);
	public abstract boolean isValidEditCity(locaciones city);
	
}
