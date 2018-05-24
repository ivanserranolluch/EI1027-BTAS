package es.uji.ei1027.btas.model;

import java.util.Date;

public class Notificacion {

	private int id;
	private String dni;
	private String mensaje;
	private Date fecha;
	
	public Notificacion(int id, String dni) {
		this.id = id;
		this.dni = dni;
		this.mensaje = "se ha creado una nueva oferta para su itinerario";
		this.fecha = new Date();
	}
	public Notificacion() {
		
		
		this.mensaje = "se ha creado una nueva oferta para su itinerario";
		this.fecha = new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
