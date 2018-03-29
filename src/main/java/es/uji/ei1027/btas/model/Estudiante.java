package es.uji.ei1027.btas.model;

import java.util.HashSet;

public class Estudiante extends Persona {

	private String apellidos;
	private int numCreditosAprobados;
	private double notaMedia;
	private String itinerario;
	private int numAsigPendiente;
	private int semestreInicioEstancia;
	private String al;
	private HashSet<PreferenciasEstudiante> preferencias;


	public Estudiante() {super();}

	public Estudiante(String dni, Direccion direccion, String nombre, String apellidos, String telefono, String email, 
			int numCreditosAprobados, double notaMedia,String itinerario, int numAsigPendiente, int semestreInicioEstancia, String al, HashSet<PreferenciasEstudiante> preferencias) {
		super(dni,direccion,nombre,telefono,email);
		this.apellidos= apellidos;
		this.numCreditosAprobados= numCreditosAprobados;
		this.notaMedia= notaMedia;
		this.itinerario=itinerario;
		this.numAsigPendiente= numAsigPendiente;
		this.semestreInicioEstancia= semestreInicioEstancia;
		this.al= al;
		this.preferencias = preferencias;
	}

	public Estudiante(Estudiante estudiante) {
		super(estudiante);
		this.apellidos= estudiante.apellidos;
		this.numCreditosAprobados= estudiante.numCreditosAprobados;
		this.notaMedia= estudiante.notaMedia;
		this.itinerario=estudiante.itinerario;
		this.numAsigPendiente= estudiante.numAsigPendiente;
		this.semestreInicioEstancia= estudiante.semestreInicioEstancia;
		this.al= estudiante.al;
		this.preferencias = estudiante.preferencias;

		
	}

	public boolean seleccionarOferta() {

		return false;
	}
	public boolean borrarOferta() {

		return false;
	}
	public boolean ordenarOfertaPreferencia() {

		return false;
	}
	public boolean crearPeticionRevision() {

		return false;
	}


}
