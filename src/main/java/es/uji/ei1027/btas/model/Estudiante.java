package es.uji.ei1027.btas.model;

import java.util.HashSet;

public class Estudiante extends Persona {
	
	private String al;
	private String apellidos;
	private String itinerario;
	private double notaMedia;
	private int numAsigPendiente;
	private int numCreditosAprobados;
	private int semestreInicioEstancia;
	private HashSet<PreferenciasEstudiante> preferencias;


	public Estudiante() {super();}

	public Estudiante(String dni, Direccion direccion, String nombre, String apellidos, String telefono, String email, 
			int numCreditosAprobados, double notaMedia,String itinerario, int numAsigPendiente, int semestreInicioEstancia, String al, HashSet<PreferenciasEstudiante> preferencias) {
		super(dni,direccion,nombre,telefono,email);
		this.al= al;
		this.apellidos= apellidos;
		this.numCreditosAprobados= numCreditosAprobados;
		this.notaMedia= notaMedia;
		this.itinerario=itinerario;
		this.numAsigPendiente= numAsigPendiente;
		this.semestreInicioEstancia= semestreInicioEstancia;
		this.preferencias = preferencias;
	}

	public Estudiante(Estudiante estudiante) {
		super(estudiante);
		this.al= estudiante.al;
		this.apellidos= estudiante.apellidos;
		this.numCreditosAprobados= estudiante.numCreditosAprobados;
		this.notaMedia= estudiante.notaMedia;
		this.itinerario=estudiante.itinerario;
		this.numAsigPendiente= estudiante.numAsigPendiente;
		this.semestreInicioEstancia= estudiante.semestreInicioEstancia;
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

	public void setAl(String al) {
		this.al = al;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setNumCreditosAprobados(int numCreditosAprobados) {
		this.numCreditosAprobados = numCreditosAprobados;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}

	public void setNumAsigPendiente(int numAsigPendiente) {
		this.numAsigPendiente = numAsigPendiente;
	}

	public void setSemestreInicioEstancia(int semestreInicioEstancia) {
		this.semestreInicioEstancia = semestreInicioEstancia;
	}

	public void setPreferencias(HashSet<PreferenciasEstudiante> preferencias) {
		this.preferencias = preferencias;
	}

	public String getAl() {
		return al;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getNumCreditosAprobados() {
		return numCreditosAprobados;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public String getItinerario() {
		return itinerario;
	}

	public int getNumAsigPendiente() {
		return numAsigPendiente;
	}

	public int getSemestreInicioEstancia() {
		return semestreInicioEstancia;
	}

	public HashSet<PreferenciasEstudiante> getPreferencias() {
		return preferencias;
	}
	

}
