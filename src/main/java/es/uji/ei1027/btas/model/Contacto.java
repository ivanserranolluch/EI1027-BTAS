package es.uji.ei1027.btas.model;

import java.util.List;

public abstract class Contacto {

	private int id;
	private List<Integer> listaDirecciones;
	private String nombre;
	private int telefono;
	private String email;
	
	public Contacto() {
		super();
	}
	
	public Contacto(int id, List<Integer> lista, String nombre, int telefono, String email) {
		this.id=id;
		this.listaDirecciones=lista;
		this.nombre=nombre;
		this.telefono=telefono;
		this.email=email;
	}
	
	public abstract  List<Integer> getDirecciones();
	
	public abstract String getNombre();
	
	public abstract void setNombre(String nombre);
	
	public abstract int getTelefono();
	
	public abstract void setTelefono(int telefono);
	
	public abstract String getEmail();
	
	public abstract void setEmail(String email);
}
