package es.uji.ei1027.btas.model;

public enum EstadoAsignacion {

	ACEPTADA("Aceptada"),
	RECHAZADA("Rechazada"),
	TRASPASADA("Traspasada");
	
	private String descripcion;
	
	private EstadoAsignacion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
