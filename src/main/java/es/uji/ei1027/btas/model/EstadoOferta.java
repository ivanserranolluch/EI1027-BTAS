package es.uji.ei1027.btas.model;

public enum EstadoOferta {
	
	SIN_DEFINIR("Sin Definir"),
	INTRODUCIDA("Introducida"),
	PENDIENTE_REVISION("Pendiente de revision"),
	ACEPTADA("Aceptada"),
	RECHAZADA("Rechazada"),
	VISIBLE_ALUMNOS("Visible alumnos"),
	ASIGNADA("Asignada"),
	SOLICITAR_REVISION("Solicitar Revision");
	
	private String descripcion;
	
	private EstadoOferta(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
