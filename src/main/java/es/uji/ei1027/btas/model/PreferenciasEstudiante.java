package es.uji.ei1027.btas.model;

import java.sql.Date;


public class PreferenciasEstudiante {
	private int id;
	private String estudianteDni;
	private String ofertaProyectoId;
	private int orden;
	private String estado;
	private Date fechaUltimoCambio;
	
	
	
	public PreferenciasEstudiante() {
		super();
	}
	
	public PreferenciasEstudiante(int id,String estudianteDni, String ofertaProyectoId,
			int orden,Date fechaUltimoCambio,String estado) {
		this.id= id;
		this.estudianteDni = estudianteDni;
		this.ofertaProyectoId = ofertaProyectoId;
		this.orden = orden;
		this.fechaUltimoCambio = fechaUltimoCambio;
		this.estado = estado;
	}
	
	public PreferenciasEstudiante (PreferenciasEstudiante preferenciasEstudiante) {
		
		this.id= preferenciasEstudiante.id;
		this.estudianteDni = preferenciasEstudiante.estudianteDni;
		this.ofertaProyectoId = preferenciasEstudiante.ofertaProyectoId;
		this.orden = preferenciasEstudiante.orden;
		this.fechaUltimoCambio = preferenciasEstudiante.fechaUltimoCambio;
		this.estado = preferenciasEstudiante.estado;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstudianteDni() {
		return estudianteDni;
	}
	public void setEstudianteDni(String estudianteDni) {
		this.estudianteDni = estudianteDni;
	}
	public String getOfertaProyectoId() {
		return ofertaProyectoId;
	}
	public void setOfertaProyectoId(String ofertaProyectoId) {
		this.ofertaProyectoId = ofertaProyectoId;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public Date getFechaUltimoCambio() {
		return fechaUltimoCambio;
	}
	public void setFechaUltimoCambio(Date fechaUltimoCambio) {
		this.fechaUltimoCambio = fechaUltimoCambio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
