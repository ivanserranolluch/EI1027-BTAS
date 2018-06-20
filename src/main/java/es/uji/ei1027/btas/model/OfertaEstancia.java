package es.uji.ei1027.btas.model;

import java.util.Date;

public class OfertaEstancia {
	private int id_oferta;
	private Date fechaAlta;
	private EstadoOferta estado;
	private String descEstado;
	private String objetivo;
	private String tarea;
	private int id_estancia;
	private String descripcion;
	private int semestre;
	private String cif;
	
	public OfertaEstancia() {
		this.estado=EstadoOferta.INTRODUCIDA;
		this.descEstado=EstadoOferta.INTRODUCIDA.getDescripcion();
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_estancia() {
		return id_estancia;
	}

	public void setId_estancia(int id_estancia) {
		this.id_estancia = id_estancia;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getDescEstado() {
		return descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}

	public int getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(int id_oferta) {
		this.id_oferta = id_oferta;
	}

	public EstadoOferta getEstado() {
		return estado;
	}

	public void setEstado(String descripcionEstado) {
		switch(descripcionEstado) {	
		case "Sin definir":
			estado=EstadoOferta.SIN_DEFINIR;
			break;
		case "Introducida":
			estado=EstadoOferta.INTRODUCIDA;
			break;
		case "Pendiente de revision":
			estado=EstadoOferta.PENDIENTE_REVISION;
			break;
		case "Aceptada":
			estado=EstadoOferta.ACEPTADA;
			break;
		case "Rechazada":
			estado=EstadoOferta.RECHAZADA;
			break;
		case "Visible alumnos":
			estado=EstadoOferta.VISIBLE_ALUMNOS;
		case "Asignada":
			estado=EstadoOferta.ASIGNADA;
			break;
		}
		this.descEstado=estado.getDescripcion();
	}
	
}
