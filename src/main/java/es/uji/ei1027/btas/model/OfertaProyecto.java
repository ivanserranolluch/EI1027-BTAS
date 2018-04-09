package es.uji.ei1027.btas.model;

import java.sql.Time;
import java.util.HashSet;

public class OfertaProyecto {
	
	private int id;
	private String tarea;
	private String objetivo;
	private EstadoOferta estado;
	private Itinerario itinerario;
	private Time fechaAlta;
	//private Time fechaUltimoCambio;
	private HashSet<Asignacion> asignaciones;
	private HashSet<PeticionRevision> peticionesRevision;
	
	
	public OfertaProyecto() {
		super();
	}
	
	public OfertaProyecto(int id, String tarea, String objetivo, Time fechaAlta, HashSet<Asignacion> asignaciones,HashSet<PeticionRevision> peticionesRevision) {
		this.id=id;
		this.tarea=tarea;
		this.objetivo=objetivo;
		this.fechaAlta=fechaAlta;
		this.asignaciones=asignaciones;
		this.peticionesRevision=peticionesRevision;
		this.estado=EstadoOferta.SIN_DEFINIR;
		this.itinerario=Itinerario.SIN_DEFINIR;
	}
//	public boolean introducirOferta() {
//		return false;
//	}
//	public boolean eliminarOferta() {
//		return false;
//	}
//	public boolean asignarOferta() {
//		return false;
//	}

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
		case "Visible para los alumnos":
			estado=EstadoOferta.VISIBLE_ALUMNOS;
		case "Asignada":
			estado=EstadoOferta.ASIGNADA;
			break;
		}
	}
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public void setFechaAlta(Time time) {
		this.fechaAlta = time;
	}
	
	public String getItinerario() {
		return itinerario.getDescripcion();
	}
	public void setItinerario(String itinerarioDescrip) {
		switch(itinerarioDescrip) {	
		case "Sin definir":
			itinerario=Itinerario.SIN_DEFINIR;
			break;
		case "Ingenieria de Software":
			itinerario=Itinerario.INGENIERIA_SOFTWARE;
			break;
		case "Sistemas de la Informacion":
			itinerario=Itinerario.SISTEMAS_INFORMACION;
			break;
		case "Tecnologias de la Informacion":
			itinerario=Itinerario.TECNOLOGIAS_INFORMACION;
			break;
		case "Ingenieria de Computadores":
			itinerario=Itinerario.INGENIERIA_COMPUTADORES;
			break;
		}
	}
	public HashSet<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	public void setAsignaciones(HashSet<Asignacion> asignaciones) {
		this.asignaciones= asignaciones;
	}
	public HashSet<PeticionRevision> getPeticionesRevision() {
		return peticionesRevision;
	}
	public void setPeticionesRevision(HashSet<PeticionRevision> peticionesRevision) {
		this.peticionesRevision = peticionesRevision;
	}
	public EstadoOferta getEstado() {
		return estado;
	}
	
	public Time getFechaDeAlta() {
		return fechaAlta;
	}
	
	
	
}
