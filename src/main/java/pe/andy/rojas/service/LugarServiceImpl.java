package pe.andy.rojas.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.andy.rojas.entity.locaciones;
import pe.andy.rojas.repository.lugarRepository;


@Service
public class LugarServiceImpl implements LugarService {

	
	@Autowired
	private lugarRepository repository;
	
	@Override
	@Transactional
	public void insert(locaciones locacions) {
		repository.save(locacions);
	}

	@Override
	@Transactional
	public void update(locaciones locacions) {
		repository.save(locacions);
	}

	@Override
	@Transactional
	public void delete(Integer locationId) {
		repository.deleteById(locationId);
	}

	@Override
	@Transactional(readOnly = true)
	public locaciones findById(Integer locationId) {
		return repository.findById(locationId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<locaciones> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public locaciones findByCity(String city) {
		return repository.findByCity(city);
	}

	@Override
	public boolean isValidEditCity(locaciones city) {
		Collection<locaciones> baraja=new ArrayList<>(this.findAll());		
		baraja.remove(city);
		
		for(locaciones carta:baraja)
		{
			if(carta.getCity().equals(city.getCity())) {
				return false;
			}
		}		
		
		return true;
	}

}
