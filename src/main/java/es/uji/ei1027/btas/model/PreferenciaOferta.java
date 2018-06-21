package es.uji.ei1027.btas.model;

import java.sql.Date;

public class PreferenciaOferta {
	
	private int id;
	private Estudiante estudiante;
	private OfertaProyecto ofertaProyecto;
	private int orden;
	private EstadoOferta estado;
	private String dni;
	private String descEstado;
	private Date fechaUltimoCambio;
	private Date fechaAlta;
	private Itinerario itinerario;
	private String descItinerario;
	private String cif;
	private String tarea;
	private String objetivo;
	
	public PreferenciaOferta() {
		this.estado=EstadoOferta.INTRODUCIDA;
		this.descEstado=EstadoOferta.INTRODUCIDA.getDescripcion();
	}
	
	
	public Itinerario getItinerario() {
		return itinerario;
	}
	public void setItinerario(String itinerarioDescrip) {
		switch(itinerarioDescrip) {	
		case "Sin definir":
			this.itinerario=Itinerario.SIN_DEFINIR;
			break;
		case "Ingenieria de Software":
			this.itinerario=Itinerario.INGENIERIA_SOFTWARE;
			break;
		case "Sistemes de Informacio":
			this.itinerario=Itinerario.SISTEMAS_INFORMACION;
			break;
		case "Tecnologias Web":
			this.itinerario=Itinerario.TECNOLOGIAS_INFORMACION;
			break;
		case "Ingenieria de Computadores":
			this.itinerario=Itinerario.INGENIERIA_COMPUTADORES;
			break;
		}
		this.setDescItinerario(itinerario.getDescripcion());
	}
	
	public Date getFechaUltimoCambio() {
		return fechaUltimoCambio;
	}
	public void setFechaUltimoCambio(Date fechaUltimoCambio) {
		this.fechaUltimoCambio = fechaUltimoCambio;
	}

	public String getDescEstado() {
		return descEstado;
	}
	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public OfertaProyecto getOfertaProyecto() {
		return ofertaProyecto;
	}
	public void setOfertaProyecto(OfertaProyecto ofertaProyecto) {
		this.ofertaProyecto = ofertaProyecto;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescItinerario() {
		return descItinerario;
	}
	public void setDescItinerario(String descItinerario) {
		this.descItinerario = descItinerario;
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


	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
	}



}
