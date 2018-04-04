package es.uji.ei1027.btas.model;

public class Direccion {

	private CP cp;
	private String direccion;
	private String numeroVivienda;
	
	public Direccion(){
		super();
	}
	
	public Direccion(CP cp, String direccion, String numeroVivienda){
		this.cp=cp;
		this.direccion=direccion;
		this.numeroVivienda=numeroVivienda;
	}

	public CP getCp() {
		return cp;
	}

	public void setCp(CP cp) {
		this.cp = cp;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroVivienda() {
		return numeroVivienda;
	}

	public void setNumeroVivienda(String numeroVivienda) {
		this.numeroVivienda = numeroVivienda;
	}
	
	
}
