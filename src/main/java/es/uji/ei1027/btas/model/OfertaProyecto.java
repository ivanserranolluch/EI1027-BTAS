package es.uji.ei1027.btas.model;

import java.util.Calendar;
import java.util.HashSet;

public class OfertaProyecto {
	
	private String id;
	private String tarea;
	private String objetivo;
	private String estado;
	private Calendar fechaAlta;
	private Calendar fechaUltimoCambio;
	private String itinerario;
	private HashSet<Estudiante> estudiantesInscritos;
	private HashSet<PeticionRevision> peticionesRevision;
	
	
	public OfertaProyecto( String id,String tarea,String objetivo,String estado,
	Calendar fechaAlta,Calendar fechaUltimoCambio,String itinerario, HashSet<Estudiante> estudiantesInscritos){
		
		this.id = id;
		this.tarea = tarea;
		this.objetivo= objetivo;
		this.estado= estado;
		this.fechaAlta= fechaAlta;
		this.fechaUltimoCambio = fechaUltimoCambio;
		this.itinerario = itinerario;
		this.estudiantesInscritos = estudiantesInscritos;
	}
	
	public OfertaProyecto(OfertaProyecto ofertaProyecto) {
		
		this.id = ofertaProyecto.id;
		this.tarea = ofertaProyecto.tarea;
		this.objetivo= ofertaProyecto.objetivo;
		this.estado= ofertaProyecto.estado;
		this.fechaAlta= ofertaProyecto.fechaAlta;
		this.fechaUltimoCambio = ofertaProyecto.fechaUltimoCambio;
		this.itinerario = ofertaProyecto.itinerario;
		this.estudiantesInscritos = ofertaProyecto.estudiantesInscritos;
		
		
	}
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
	
}
