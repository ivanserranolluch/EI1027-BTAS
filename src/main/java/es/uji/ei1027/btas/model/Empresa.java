package es.uji.ei1027.btas.model;

import java.util.Set;

public class Empresa {

	private String cif;
	private Direccion direccion;
	private String nombre;
	private String telefono;
	private String email; 
	private String direccionWeb;
	private Set<Estancia> ofertasEstancia;


	public Empresa() {
		super();
	}

	public Empresa(String cif, Direccion direccion, String nombre, String telefono, String email, String direccionWeb,Set<Estancia> ofertasEstancia ) {
		this.cif = cif;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono =telefono;
		this.email = email;
		this.direccionWeb = direccionWeb;
		this.ofertasEstancia = ofertasEstancia;

	}
	public Empresa(Empresa empresa ) {
		this.cif = empresa.cif;
		this.direccion = empresa.direccion;
		this.nombre = empresa.nombre;
		this.telefono= empresa.telefono;
		this.email = empresa.email;
		this.direccionWeb= empresa.direccionWeb;
		this.ofertasEstancia = empresa.ofertasEstancia;

	}
	
}
