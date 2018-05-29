package es.uji.ei1027.btas.dao;

import java.util.List;

import es.uji.ei1027.btas.model.Empresa;
import es.uji.ei1027.btas.model.Estancia;
import es.uji.ei1027.btas.model.PersonaContacto;


public interface PersonaContactoDAOInterface {
	
	public List<PersonaContacto> getPersonaContactos(String cif);
	
	public PersonaContacto getPersonaContacto(String dni);
	
	public void addPersonaContacto(PersonaContacto personaContacto);
		
	public void updatePersonaContacto(String dni, String dniN, String cif);
	
	public void deletePersonaContacto(String dni);

}
