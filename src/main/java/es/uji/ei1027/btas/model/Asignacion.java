package es.uji.ei1027.btas.model;

import java.util.Date;

public class Asignacion {

	private Date fechaAceptacion;
	private AceptadaRechazada estadoAceptadaRechazada;
	private String descEstado;
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
	
	public Asignacion(int id_oferta,Date fechaAceptacion,String dniE,String dniT) {
		super();
		this.id_oferta=id_oferta;
		this.fechaAceptacion=fechaAceptacion;
		
		this.dniE=dniE;
		this.dniT=dniT;
		this.estadoAceptadaRechazada=AceptadaRechazada.SIN_DEFINIR;
		this.setDescEstado(AceptadaRechazada.SIN_DEFINIR.getAceptadaRechazada());
		
	}
	

	public Date getFechaAceptacion() {
		return fechaAceptacion;
	}
	public void setFechaAceptacion(Date fechaAceptacion) {
		this.fechaAceptacion = fechaAceptacion;
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
