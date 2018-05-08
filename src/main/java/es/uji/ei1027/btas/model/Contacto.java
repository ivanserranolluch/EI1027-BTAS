package es.uji.ei1027.btas.model;

import java.util.List;

public abstract class Contacto {

	private String id;
	private Direccion direccion;
	private String nombre;
	private int telefono;
	private String email;
	
	public Contacto() {
		super();
	}
	
	public Contacto(String id, Direccion direccion, String nombre, int telefono, String email) {
		this.id=id;
		this.direccion=direccion;
		this.nombre=nombre;
		this.telefono=telefono;
		this.email=email;
	}
	
	public String getId() {
		return id;
	}
	
	public Direccion getDireccion(){
		return direccion;
	}
	
	public void setDirecciones(List<Direccion> direcciones) {
		direccion=direccion;
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
