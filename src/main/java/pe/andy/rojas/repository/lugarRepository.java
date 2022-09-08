package pe.andy.rojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.andy.rojas.entity.locaciones;

public interface lugarRepository extends JpaRepository<locaciones, Integer>{

	@Query(value="select * from lugar where city=:city",nativeQuery=true)
	public abstract locaciones findByCity(String city);
	
}
