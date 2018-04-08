package es.uji.ei1027.btas.model;

public enum EstadoOferta {
	
	SIN_DEFINIR("Sin definir"),
	INTRODUCIDA("Introducida"),
	PENDIENTE_REVISION("Pendiente de revision"),
	ACEPTADA("Aceptada"),
	RECHAZADA("Rechazada"),
	VISIBLE_ALUMNOS("Visible para los alumnos"),
	ASIGNADA("Asignada");
	
	private String descripcion;
	
	private EstadoOferta(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
