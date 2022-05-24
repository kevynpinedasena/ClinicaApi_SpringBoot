package com.kevyn.ws.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kevyn.ws.utilidades.PersonasUtilidades;
import com.kevyn.ws.vo.PersonaVo;

@Service
public class PersonaDao {

	public PersonaDao() {
		PersonasUtilidades.iniciarLista();
	}
	
	public PersonaVo consultarPersonaIndividual(String documento) {
		
		PersonaVo miPersonaVo = null;
		
		for (PersonaVo p : PersonasUtilidades.listaPersonas) {
			if ( p.getDocumento().equals(documento) ) {
				miPersonaVo = new PersonaVo();
				miPersonaVo.setDocumento(p.getDocumento());
				miPersonaVo.setNombre(p.getNombre());
				miPersonaVo.setTelefono(p.getTelefono());
				miPersonaVo.setEdad(p.getEdad());
				miPersonaVo.setProfesion(p.getProfesion());
				miPersonaVo.setPassword(p.getPassword());
				miPersonaVo.setTipo(p.getTipo());
			}
		}
		return miPersonaVo;
	}

	public List<PersonaVo> obtenerListaDePersonas() {
		
		return PersonasUtilidades.listaPersonas;
	}
	
	public PersonaVo registrarPersona(PersonaVo miPersonaVo) {
		boolean existe = false;
		
		for (PersonaVo obj : PersonasUtilidades.listaPersonas) {
			if(obj.getDocumento().equals(miPersonaVo.getDocumento())) {
				existe = true;
				break;
			}
		}
		if (existe == false) {
			miPersonaVo.setPassword(miPersonaVo.getDocumento());
			PersonasUtilidades.listaPersonas.add(miPersonaVo);
			return miPersonaVo;
		}
		else {
			return null;
		}
	}
	
	public PersonaVo consultarLogin(String documento, String pass) {
		
		PersonaVo persona = null;
		
		for (PersonaVo p : PersonasUtilidades.listaPersonas) {
			
			if(p.getDocumento().equals(documento) && p.getPassword().equals(pass)) {
				persona = p;
				break;
			}
		}
		return persona;
	}
	
	
	public PersonaVo actualizarPersona(PersonaVo persona) {
		
		PersonaVo personaVo = null;
		
		for (PersonaVo obj : PersonasUtilidades.listaPersonas) {
			if (obj.getDocumento().equals(persona.getDocumento())) {
				obj.setDocumento(persona.getDocumento());
				obj.setNombre(persona.getNombre());
				obj.setTelefono(persona.getTelefono());
				obj.setEdad(persona.getEdad());
				obj.setProfesion(persona.getProfesion());
				obj.setPassword(persona.getPassword());
				obj.setTipo(persona.getTipo());
				personaVo = obj;
				break;
			}
		}
		return personaVo;
	}
	
	public void eliminarPersona(PersonaVo persona) {
		for (PersonaVo obj : PersonasUtilidades.listaPersonas) {
			if (obj.getDocumento().equals(persona.getDocumento())) {
				PersonasUtilidades.listaPersonas.remove(obj);
				break;
			}
			
		}
		
	}
}
