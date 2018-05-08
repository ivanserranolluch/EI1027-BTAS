package es.uji.ei1027.btas.model;

import java.sql.Date;

public class Asignacion {

	private Date fechaPropuesta;
	private Date fechaAceptacion;
	private EstadoAsignacion estadoAsignacion;
	private Date fechaRechazo;
	private Date fechaTraspaso;
	private String comentarioPetCambio;
	private String dniE;
	private String dniT;
	private Integer id_oferta;
	
	public Asignacion() {
		super();
	}

	public Asignacion(Date fechaPropuesta, Date fechaAceptacion, EstadoAsignacion estadoAsignacion, Date fechaRechazo,
			Date fechaTraspaso, String comentarioPetCambio, String dniE, String dniT, Integer id_oferta) {
		super();
		this.fechaPropuesta = fechaPropuesta;
		this.fechaAceptacion = fechaAceptacion;
		this.estadoAsignacion = estadoAsignacion;
		this.fechaRechazo = fechaRechazo;
		this.fechaTraspaso = fechaTraspaso;
		this.comentarioPetCambio = comentarioPetCambio;
		this.dniE = dniE;
		this.dniT = dniT;
		this.id_oferta = id_oferta;
	}

	public Date getFechaPropuesta() {
		return fechaPropuesta;
	}

	public void setFechaPropuesta(Date fechaPropuesta) {
		this.fechaPropuesta = fechaPropuesta;
	}

	public Date getFechaAceptacion() {
		return fechaAceptacion;
	}

	public void setFechaAceptacion(Date fechaAceptacion) {
		this.fechaAceptacion = fechaAceptacion;
	}

	public EstadoAsignacion getEstadoAsignacion() {
		return estadoAsignacion;
	}

	public void setEstadoAsignacion(EstadoAsignacion estadoAsignacion) {
		this.estadoAsignacion = estadoAsignacion;
	}

	public Date getFechaRechazo() {
		return fechaRechazo;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}

	public Date getFechaTraspaso() {
		return fechaTraspaso;
	}

	public void setFechaTraspaso(Date fechaTraspaso) {
		this.fechaTraspaso = fechaTraspaso;
	}

	public String getComentarioPetCambio() {
		return comentarioPetCambio;
	}

	public void setComentarioPetCambio(String comentarioPetCambio) {
		this.comentarioPetCambio = comentarioPetCambio;
	}

	public String getDniE() {
		return dniE;
	}

	public void setDniE(String dniE) {
		this.dniE = dniE;
	}

	public String getDniT() {
		return dniT;
	}

	public void setDniT(String dniT) {
		this.dniT = dniT;
	}

	public Integer getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(Integer id_oferta) {
		this.id_oferta = id_oferta;
	}
}
