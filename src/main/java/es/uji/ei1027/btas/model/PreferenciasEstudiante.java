package es.uji.ei1027.btas.model;
import java.sql.Date;

public class PreferenciasEstudiante {
	
	private int id;
	private Estudiante estudiante;
	private OfertaProyecto ofertaProyecto;
	private String orden;
	private EstadoOferta estado;
	private String dni;
	private String descEstado;
	private Date fechaUltimoCambio;
	
	
	
	public PreferenciasEstudiante() {
		super();
		this.estado=EstadoOferta.INTRODUCIDA;
		this.descEstado=EstadoOferta.INTRODUCIDA.getDescripcion();
	}
	
	public PreferenciasEstudiante(int id,Estudiante estudiante, OfertaProyecto ofertaProyecto,
			String orden,Date fechaUltimoCambio,String dni) {
		this.id= id;
		this.dni=dni;
		this.estudiante = estudiante;
		this.ofertaProyecto = ofertaProyecto;
		this.orden = orden;
		this.fechaUltimoCambio = fechaUltimoCambio;
		this.estado=EstadoOferta.INTRODUCIDA;
		this.descEstado=EstadoOferta.INTRODUCIDA.getDescripcion();
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public OfertaProyecto getOfertaProyecto() {
		return ofertaProyecto;
	}

	public void setOfertaProyecto(OfertaProyecto ofertaProyecto) {
		this.ofertaProyecto = ofertaProyecto;
	}

	public PreferenciasEstudiante (PreferenciasEstudiante preferenciasEstudiante) {
		
		this.id= preferenciasEstudiante.id;
		this.estudiante = preferenciasEstudiante.estudiante;
		this.ofertaProyecto = preferenciasEstudiante.ofertaProyecto;
		this.orden = preferenciasEstudiante.orden;
		this.fechaUltimoCambio = preferenciasEstudiante.fechaUltimoCambio;
		this.estado = preferenciasEstudiante.estado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public Date getFechaUltimoCambio() {
		return fechaUltimoCambio;
	}
	public void setFechaUltimoCambio(Date fechaUltimoCambio) {
		this.fechaUltimoCambio = fechaUltimoCambio;
	}
	public EstadoOferta getEstado() {
		return estado;
	}
	public String getDescEstado() {
		return descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
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
	public boolean introducirPreferencia(PreferenciasEstudiante preferencia) {
		if (preferencia.estudiante.getPreferencias().size()<4)
			preferencia.estudiante.getPreferencias().add(preferencia);
		return false;
	}

}
