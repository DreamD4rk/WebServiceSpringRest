package pe.andy.rojas.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.andy.rojas.entity.locaciones;
import pe.andy.rojas.service.LugarService;


@RestController	
@RequestMapping("/locacion")
public class locacionesController {

	@Autowired
	private LugarService lugarService;
	
	public locacionesController() {		
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		
		Collection<locaciones> clientesDb=lugarService.findAll();
		
		if(clientesDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientesDb,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody locaciones locacions){
		
		locaciones clienteDb=lugarService.findByCity(locacions.getCity());
		
		if(clienteDb!=null) {
			return new ResponseEntity<>("¡Locacion ya existe!",HttpStatus.CONFLICT);
		}
		
		lugarService.insert(locacions);		
		return new ResponseEntity<>("¡Cliente registrado!",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{locationId}")
	public ResponseEntity<?> editar_PUT(@RequestBody locaciones locacions,@PathVariable Integer locationId)
	{
		locaciones clienteDb=lugarService.findById(locationId);
		
		if(clienteDb!=null)
		{
			if(lugarService.isValidEditCity(locacions))
			{
				clienteDb.setDireccion(locacions.getDireccion());
				clienteDb.setPostalCode(locacions.getPostalCode());
				clienteDb.setCity(locacions.getCity());
				clienteDb.setProvincita(locacions.getProvincita());
				clienteDb.setPaisId(locacions.getPaisId());

				lugarService.update(clienteDb);
				return new ResponseEntity<>("¡Lugar actualizado!",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("¡Lugar ya existe!",HttpStatus.CONFLICT);
			}
		}
		
		return new ResponseEntity<>("¡ID del lugar no existe!",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{locationId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer locationId)
	{
		locaciones clienteDb=lugarService.findById(locationId);
		
		if(clienteDb!=null)
		{
			lugarService.delete(locationId);
			return new ResponseEntity<>("¡Lugar eliminado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡ID del lugar no existe!",HttpStatus.NOT_FOUND);
	}
}











