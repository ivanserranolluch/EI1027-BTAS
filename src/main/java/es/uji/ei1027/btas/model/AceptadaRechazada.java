package es.uji.ei1027.btas.model;

public enum AceptadaRechazada {
	
	ACEPTADA("Aceptada"),
	RECHAZADA("Rechazada"),
	SIN_DEFINIR("SinDefinir");
	
	private String aceptadaRechazada;
	
	private AceptadaRechazada(String aceptadaRechazada) {
		this.aceptadaRechazada=aceptadaRechazada;
	}
	
	public String getDescripcion() {
		return aceptadaRechazada;
	}
	
}
