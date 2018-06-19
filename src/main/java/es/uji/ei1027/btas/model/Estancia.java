package es.uji.ei1027.btas.model;

public class Estancia {

	private int id_estancia;
	private String descripcion;
	private String dni;
	private String cif;
	private int semestre;
	
	public Estancia() {
		
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
	
	public void setId_estancia(int id_estancia) {
		this.id_estancia=id_estancia;
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

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	
	
}
