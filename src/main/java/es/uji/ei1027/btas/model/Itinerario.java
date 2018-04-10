package es.uji.ei1027.btas.model;

public enum Itinerario {

	SIN_DEFINIR("Sin definir"),
	INGENIERIA_SOFTWARE("Ingenieria de Software"),
	SISTEMAS_INFORMACION("Sistemes de Informacio"),
	TECNOLOGIAS_INFORMACION("Tecnologias Web"),
	INGENIERIA_COMPUTADORES("Ingenieria de Computadores");
	
	private String descripcion;
	
	private Itinerario(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
