package es.uji.ei1027.btas.model;

import java.util.List;

public abstract class Contacto {

	private String id;
	private List<Direccion> listaDirecciones;
	private String nombre;
	private int telefono;
	private String email;
	
	public Contacto() {
		super();
	}
	
	public Contacto(String id, List<Direccion> lista, String nombre, int telefono, String email) {
		this.id=id;
		this.listaDirecciones=lista;
		this.nombre=nombre;
		this.telefono=telefono;
		this.email=email;
	}
	
	public String getId() {
		return id;
	}
	
	public List<Direccion> getDirecciones(){
		return listaDirecciones;
	}
	
	public void setDirecciones(List<Direccion> direcciones) {
		listaDirecciones=direcciones;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public  void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public  void setTelefono(int telefono) {
		this.telefono=telefono;
	}
	
	public  String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}

	public void setId(String nuevoDni) {
		id=nuevoDni;
		
	}
}
