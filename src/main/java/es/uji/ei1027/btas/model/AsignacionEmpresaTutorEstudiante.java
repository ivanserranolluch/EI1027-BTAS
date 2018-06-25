package es.uji.ei1027.btas.model;

import java.util.Date;

public class AsignacionEmpresaTutorEstudiante {
	private Date fechaAceptacion;
	private AceptadaRechazada estadoAceptadaRechazada;
	private String descEstado;
	private String dniE;
	private String dniT;
	private int id_oferta;
	private String nombreEstudiante;
	private String nombreEmpresa;
	private String nombreTutor;
	private String cif;
	
	public AsignacionEmpresaTutorEstudiante() {
		super();
		this.estadoAceptadaRechazada=AceptadaRechazada.SIN_DEFINIR;
		this.descEstado=AceptadaRechazada.SIN_DEFINIR.getDescripcion();
		
	}
	public AsignacionEmpresaTutorEstudiante(int id_oferta) {
		super();
		this.id_oferta=id_oferta;
		this.estadoAceptadaRechazada=AceptadaRechazada.SIN_DEFINIR;
		this.descEstado=AceptadaRechazada.SIN_DEFINIR.getDescripcion();
		
	}
	public AsignacionEmpresaTutorEstudiante(int id_oferta,Date fechaAceptacion,String dniE,String dniT,String nombreEmpresa, String nombreTutor, String nombreEstudiante, String cif) {
		super();
		this.id_oferta=id_oferta;
		this.fechaAceptacion=fechaAceptacion;
		this.nombreEmpresa=nombreEmpresa;
		this.nombreEstudiante=nombreEstudiante;
		this.nombreTutor=nombreTutor;
		this.cif=cif;
		this.dniE=dniE;
		this.dniT=dniT;
		this.estadoAceptadaRechazada=AceptadaRechazada.SIN_DEFINIR;
		this.descEstado=AceptadaRechazada.SIN_DEFINIR.getDescripcion();
		
	}
	
	public void setEstadoAceptadaRechazada(String descEstado) {
		switch(descEstado) {	
		case "Sin definir":
			estadoAceptadaRechazada=AceptadaRechazada.SIN_DEFINIR;
			break;
		case "Rechazada":
			estadoAceptadaRechazada=AceptadaRechazada.RECHAZADA;
			break;
		case "Aceptada":
			estadoAceptadaRechazada=AceptadaRechazada.ACEPTADA;
			break;

		}
		this.descEstado=estadoAceptadaRechazada.getDescripcion();
	}
	public AceptadaRechazada getEstado() {
		return estadoAceptadaRechazada;
	}
	public String getDescEstado() {
		return descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}
	
	public Date getFechaAceptacion() {
		return fechaAceptacion;
	}
	public void setFechaAceptacion(Date fechaAceptacion) {
		this.fechaAceptacion = fechaAceptacion;
	}
	public String getDniT() {
		return dniT;
	}
	public void setDniT(String dniT) {
		this.dniT = dniT;
	}
	public String getDniE() {
		return dniE;
	}
	public void setDniE(String dniE) {
		this.dniE = dniE;
	}
	public int getId_oferta() {
		return id_oferta;
	}
	public void setId_oferta(int id_oferta) {
		this.id_oferta = id_oferta;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNombreTutor() {
		return nombreTutor;
	}
	public void setNombreTutor(String nombreTutor) {
		this.nombreTutor = nombreTutor;
	}
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}
	
	
}
