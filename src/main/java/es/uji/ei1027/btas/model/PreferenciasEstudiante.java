package es.uji.ei1027.btas.model;

import java.sql.Date;


public class PreferenciasEstudiante {
	private int id;
	private Estudiante estudiante;
	private OfertaProyecto ofertaProyecto;
	private int orden;
	private String estado;
	private Date fechaUltimoCambio;
	
	
	
	public PreferenciasEstudiante() {
		super();
	}
	
	public PreferenciasEstudiante(int id,Estudiante estudiante, OfertaProyecto ofertaProyecto,
			int orden,Date fechaUltimoCambio,String estado) {
		this.id= id;
		this.estudiante = estudiante;
		this.ofertaProyecto = ofertaProyecto;
		this.orden = orden;
		this.fechaUltimoCambio = fechaUltimoCambio;
		this.estado = estado;
	}
	
	public PreferenciasEstudiante (PreferenciasEstudiante preferenciasEstudiante) {
		
		this.id= preferenciasEstudiante.id;
		this.estudiante = preferenciasEstudiante.estudiante;
		this.ofertaProyecto = preferenciasEstudiante.ofertaProyecto;
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public OfertaProyecto getOfertaProyecto() {
		return ofertaProyecto;
	}

	public void setOfertaProyecto(OfertaProyecto ofertaProyecto) {
		this.ofertaProyecto = ofertaProyecto;
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
