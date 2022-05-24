package com.kevyn.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevyn.ws.dao.PersonaDao;
import com.kevyn.ws.vo.PersonaVo;

@RestController
@RequestMapping("/servicio")
public class PersonasService {
	
	@Autowired(required = true)
	private PersonaDao personaDao;
	
	@GetMapping("hola")
	public String saludo() {
		return "este el saludo de clinica web";
	}
	
	@GetMapping("personas/{id}")
	public ResponseEntity<PersonaVo> getPersonaId(@PathVariable("id") String documento){
		PersonaVo miPersona = personaDao.consultarPersonaIndividual(documento);
		
		if(miPersona != null) {
			return ResponseEntity.ok(miPersona);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("personasLista")
	public ResponseEntity<List<PersonaVo>> getPersona(){
		List<PersonaVo> miPersonas = personaDao.obtenerListaDePersonas();
		
		return ResponseEntity.ok(miPersonas);
	}
	
	
	@PostMapping("guardar")
	public ResponseEntity<PersonaVo> registrarPersona(@RequestBody PersonaVo persona){
		
		PersonaVo miPersona = personaDao.registrarPersona(persona);
		
		if (miPersona != null) {
			return ResponseEntity.ok(miPersona);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@PostMapping("login")
	public ResponseEntity<PersonaVo> validarUsuario(@RequestBody PersonaVo persona){
		
		PersonaVo miPersona = personaDao.consultarLogin(persona.getDocumento(), persona.getPassword());
		
		if (miPersona != null) {
			return ResponseEntity.ok(miPersona);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PutMapping("actualizar")
	public ResponseEntity<PersonaVo> actualizarUsuario(@RequestBody PersonaVo persona){
		
		PersonaVo miPersona = null;
		
		if (personaDao.consultarPersonaIndividual(persona.getDocumento()) != null) {
			miPersona = personaDao.actualizarPersona(persona);
			if (miPersona != null) {
				return ResponseEntity.ok(miPersona);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable String id){
		PersonaVo miPersona = personaDao.consultarPersonaIndividual(id);
		if (miPersona != null) {
			personaDao.eliminarPersona(miPersona);
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.notFound().build();
	}

}
