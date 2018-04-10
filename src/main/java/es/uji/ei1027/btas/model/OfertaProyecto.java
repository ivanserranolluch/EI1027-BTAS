package es.uji.ei1027.btas.model;

import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashSet;

public class OfertaProyecto {
	
	private int id;
	private String tarea;
	private String objetivo;
	private EstadoOferta estado;
	private Itinerario itinerario;
	private Date fechaAlta;
	private int idEstancia;
	//private Time fechaUltimoCambio;
	private HashSet<Asignacion> asignaciones;
	private HashSet<PeticionRevision> peticionesRevision;
	
	
	public OfertaProyecto() {
		super();
		//this.itinerario=Itinerario.SIN_DEFINIR;
		this.estado=EstadoOferta.INTRODUCIDA;

	}
	
	public OfertaProyecto(int id, String tarea, String objetivo, Date fechaAlta, HashSet<Asignacion> asignaciones,HashSet<PeticionRevision> peticionesRevision, int id_estancia) {
		this.id=id;
		this.tarea=tarea;
		this.objetivo=objetivo;
		this.fechaAlta=fechaAlta;
		this.asignaciones=asignaciones;
		this.peticionesRevision=peticionesRevision;
		this.estado=EstadoOferta.INTRODUCIDA;
		this.itinerario=Itinerario.SIN_DEFINIR;
		this.idEstancia=id_estancia;
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
	
	public void setFechaAlta(Date time) {
		this.fechaAlta = time;
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
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public int getIdEstancia(){
		return idEstancia;
	}
	
	public void setIdEstancia(int idEstancia){
		this.idEstancia=idEstancia;
	}
	
	
}
