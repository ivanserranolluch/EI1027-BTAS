package es.uji.ei1027.btas.model;

import java.util.HashSet;
import java.util.List;

public class Empresa extends Contacto{

	private String direccionWeb;
	private HashSet<Estancia> ofertasEstancia;
	private List<PersonaContacto> personasContacto;


	public Empresa() {
		super();
	}

	public Empresa(String cif, int direccion, String nombre, int telefono, String email, String direccionWeb, HashSet<Estancia> ofertasEstancia, List<PersonaContacto> personas ) {
		super(cif,direccion,nombre,telefono,email);
		this.direccionWeb = direccionWeb;
		this.ofertasEstancia = ofertasEstancia;
		this.personasContacto=personas;

	}
	/*public Empresa(Empresa empresa ) {
		this.cif = empresa.cif;
		this.direccion = empresa.direccion;
		this.nombre = empresa.nombre;
		this.telefono= empresa.telefono;
		this.email = empresa.email;
		this.direccionWeb= empresa.direccionWeb;
		this.ofertasEstancia = empresa.ofertasEstancia;

	}*/

	public String getCif() {
		return super.getId();
	}
	
	public void setCif(String nuevoCif) {
		super.setId(nuevoCif);
	}
	
	public void setDireccionWeb(String web) {
		direccionWeb=web;
	}
	
	public String getDireccionWeb() {
		return direccionWeb;
	}
	
	public HashSet<Estancia> getOfertasEstancia(){
		return ofertasEstancia;
	}
	
	public void setOfertasEstancia(HashSet<Estancia> nuevasEstancias) {
		ofertasEstancia=nuevasEstancias;
	}
	
	public void setPersonasContacto(List<PersonaContacto> personas) {
		personasContacto=personas;
	}
	
	public List<PersonaContacto> getPersonasContacto(){
		return personasContacto;
	}


	
	public int getDireccion(){
		return super.getDireccion();
	}
	
	public String getNombre() {
		return super.getNombre();
	}
	
	public int getTelefono() {
		return super.getTelefono();
	}
	
	public String getEmail() {
		return super.getEmail();
	}
	
	public void setDireccion(int idDirNuevo) {
		super.setDirecciones(idDirNuevo);
	}
	
	public void setNombre(String nombreNuevo) {
		super.setNombre(nombreNuevo);
	}
	
	public void setTelefono(int telefonoNuevo) {
		super.setTelefono(telefonoNuevo);
	}
	
	public void setEmail(String emailNuevo) {
		super.setEmail(emailNuevo);
	}
	
}
