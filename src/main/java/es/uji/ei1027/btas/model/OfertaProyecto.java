package es.uji.ei1027.btas.model;

import java.sql.Time;
import java.util.HashSet;

public class OfertaProyecto {
	
	private String id;
	private String tarea;
	private String objetivo;
	private String estado;
	private String itinerario;
	private Time fechaAlta;
	private Time fechaUltimoCambio;
	private HashSet<Estudiante> estudiantesInscritos;
	private HashSet<PeticionRevision> peticionesRevision;
	
	
	
	public boolean introducirOferta() {
		return false;
	}
	public boolean eliminarOferta() {
		return false;
	}
	public boolean asignarOferta() {
		return false;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public OfertaProyecto() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
		return itinerario;
	}
	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}
	public HashSet<Estudiante> getEstudiantesInscritos() {
		return estudiantesInscritos;
	}
	public void setEstudiantesInscritos(HashSet<Estudiante> estudiantesInscritos) {
		this.estudiantesInscritos = estudiantesInscritos;
	}
	public HashSet<PeticionRevision> getPeticionesRevision() {
		return peticionesRevision;
	}
	public void setPeticionesRevision(HashSet<PeticionRevision> peticionesRevision) {
		this.peticionesRevision = peticionesRevision;
	}
	public String getEstado() {
		return estado;
	}
	public Time getFechaUltimoCambio() {
		return fechaUltimoCambio;
	}
	public void setFechaUltimoCambio(Time fechaUltimoCambio) {
		this.fechaUltimoCambio = fechaUltimoCambio;
	}
	public Time getFechaDeAlta() {
		return fechaAlta;
	}
	
	
	
}
