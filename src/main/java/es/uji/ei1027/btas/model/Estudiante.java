package es.uji.ei1027.btas.model;

import java.util.HashSet;
import java.util.List;

public class Estudiante extends Contacto {
	
	private String al;
	private String apellidos;
	private Itinerario itinerario;
	private String descItinerario;
	private double notaMedia;
	private int numAsigPendiente;
	private int numCreditosAprobados;
	private int semestreInicioEstancia;
	private HashSet<PreferenciasEstudiante> preferencias;


	public Estudiante() {super();}

	public Estudiante(String dni, Direccion direccion, String nombre, String apellidos, int telefono, String email, 
			int numCreditosAprobados, double notaMedia, int numAsigPendiente, int semestreInicioEstancia, String al, HashSet<PreferenciasEstudiante> preferencias) {
		super(dni,direccion,nombre,telefono,email);
		this.al= al;
		this.apellidos= apellidos;
		this.numCreditosAprobados= numCreditosAprobados;
		this.notaMedia= notaMedia;
		this.itinerario=Itinerario.SIN_DEFINIR;
		this.descItinerario=Itinerario.SIN_DEFINIR.getDescripcion();
		this.numAsigPendiente= numAsigPendiente;
		this.semestreInicioEstancia= semestreInicioEstancia;
		this.preferencias = preferencias;
	}

/*	public Estudiante(Estudiante estudiante) {
		super(estudiante);
		this.al= estudiante.al;
		this.apellidos= estudiante.apellidos;
		this.numCreditosAprobados= estudiante.numCreditosAprobados;
		this.notaMedia= estudiante.notaMedia;
		this.itinerario=estudiante.itinerario;
		this.numAsigPendiente= estudiante.numAsigPendiente;
		this.semestreInicioEstancia= estudiante.semestreInicioEstancia;
		this.preferencias = estudiante.preferencias
	}*/

	

	public String getDescItinerario() {
		return descItinerario;
	}

	public void setDescItinerario(String descItinerario) {
		this.descItinerario = descItinerario;
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
		default:
			this.itinerario=Itinerario.SIN_DEFINIR;
			break;
		}
		this.descItinerario= itinerario.getDescripcion();
		
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

	public Itinerario getItinerario() {
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
	
	public String getDni(){
		return super.getId();
	}
	
	public void setDni(String nuevoDni) {
		super.setId(nuevoDni);
	}
	
	public Direccion getDireccion(){
		return super.getDireccion();
	}
	
	public String getNombre() {
		return super.getNombre();
	}
	
	public int getTelefono() {
		return super.getTelefono();
	}
	
	public String getEmail() {
		return super.getEmail();
	}
	
	public void setDirecciones(List<Direccion> lista) {
		super.setDirecciones(lista);
	}
	
	public void setNombre(String nombreNuevo) {
		super.setNombre(nombreNuevo);
	}
	
	public void setTelefono(int telefonoNuevo) {
		super.setTelefono(telefonoNuevo);
	}
	
	public void setEmail(String emailNuevo) {
		super.setEmail(emailNuevo);
	}
	
}
