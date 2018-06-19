package es.uji.ei1027.btas.model;

import java.util.Date;

public class Asignacion {
	private Date fechaPropuesta;
	private Date fechaAceptacion;
	private Date fechaRechazo;
	private Date fechaTraspasoIglu;
	private AceptadaRechazada estadoAceptadaRechazada;
	private String descEstado;
	private String comentarioPetCambio;
	private String dniE;
	private String dniT;
	private int id_oferta;
	
	public Asignacion() {
		super();
		this.estadoAceptadaRechazada=AceptadaRechazada.SIN_DEFINIR;
		this.setDescEstado(AceptadaRechazada.SIN_DEFINIR.getAceptadaRechazada());
		
	}
	
	public Asignacion(int id_oferta) {
		super();
		this.id_oferta=id_oferta;
		this.estadoAceptadaRechazada=AceptadaRechazada.SIN_DEFINIR;
		this.setDescEstado(AceptadaRechazada.SIN_DEFINIR.getAceptadaRechazada());
		
	}
	
	public Asignacion(int id_oferta,Date fechaPropuesta,Date fechaAceptacion, Date fechaRechazo,Date fechaTraspasoIglu,String comentarioPetCambio,String dniE,String dniT) {
		super();
		this.id_oferta=id_oferta;
		this.fechaAceptacion=fechaAceptacion;
		this.fechaPropuesta=fechaPropuesta;
		this.fechaRechazo=fechaRechazo;
		this.fechaTraspasoIglu=fechaTraspasoIglu;
		this.comentarioPetCambio=comentarioPetCambio;
		this.dniE=dniE;
		this.dniT=dniT;
		this.estadoAceptadaRechazada=AceptadaRechazada.SIN_DEFINIR;
		this.setDescEstado(AceptadaRechazada.SIN_DEFINIR.getAceptadaRechazada());
		
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
	public Date getFechaRechazo() {
		return fechaRechazo;
	}
	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}
	public Date getFechaTraspasoIglu() {
		return fechaTraspasoIglu;
	}
	public void setFechaTraspasoIglu(Date fechaTraspasoI) {
		this.fechaTraspasoIglu = fechaTraspasoI;
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
	public int getId_oferta() {
		return id_oferta;
	}
	public void setId_oferta(int id_oferta) {
		this.id_oferta = id_oferta;
	}

	public AceptadaRechazada getEstado() {
		return estadoAceptadaRechazada;
	}

	public void setEstado(String descEstado) {
		switch(descEstado) {	
		case "Sin definir":
			estadoAceptadaRechazada=AceptadaRechazada.SIN_DEFINIR;
			break;
		case "Introducida":
			estadoAceptadaRechazada=AceptadaRechazada.RECHAZADA;
			break;
		case "Aceptada":
			estadoAceptadaRechazada=AceptadaRechazada.ACEPTADA;
			break;

		}
		this.setDescEstado(estadoAceptadaRechazada.getAceptadaRechazada());
	}

	public String getDescEstado() {
		return descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}
}
