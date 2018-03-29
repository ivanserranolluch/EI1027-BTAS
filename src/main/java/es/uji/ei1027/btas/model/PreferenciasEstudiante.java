package es.uji.ei1027.btas.model;

import java.util.Calendar;

public class PreferenciasEstudiante {
	private int id;
	private Estudiante estudiante;
	private OfertaProyecto ofertaProyecto;
	private int orden;
	private Calendar fechaUltimoCambio;
	private String estado;
	
	
	
	public PreferenciasEstudiante(int id,Estudiante estudiante, OfertaProyecto ofertaProyecto,
			int orden,Calendar fechaUltimoCambio,String estado) {
		this.id= id;
		this.estudiante = estudiante;
		this.ofertaProyecto = ofertaProyecto;
		this.orden = orden;
		this.fechaUltimoCambio = fechaUltimoCambio;
		this.estado = estado;
	}
	
	public PreferenciasEstudiante (PreferenciasEstudiante preferenciasEstudiante) {
		
		this.id= preferenciasEstudiante.id;
		this.estudiante = preferenciasEstudiante.estudiante;
		this.ofertaProyecto = preferenciasEstudiante.ofertaProyecto;
		this.orden = preferenciasEstudiante.orden;
		this.fechaUltimoCambio = preferenciasEstudiante.fechaUltimoCambio;
		this.estado = preferenciasEstudiante.estado;
	}
}
