package es.uji.ei1027.btas.model;

public class Estancia {

	private int id_estancia;
	private String descripcion;
	private String dni;
	private String cif;
	
	public Estancia() {
		super();
	}
	
	public Estancia(String descripcion, String dni, String cif) {
		super();
		this.descripcion = descripcion;
		this.dni = dni;
		this.cif = cif;
	}

	public int getId_estancia() {
		return id_estancia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}
	
	
	
}
