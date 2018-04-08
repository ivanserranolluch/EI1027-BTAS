package es.uji.ei1027.btas.model;

import java.sql.Time;

public class PeticionRevision {
	private Time fecha;
	private String textoPeticion;
	
	public PeticionRevision() {
		super();
	}
	
	public PeticionRevision(Time fecha, String textoPeticion) {
		this.fecha=fecha;
		this.textoPeticion=textoPeticion;
	}

	public Time getFecha() {
		return fecha;
	}

	public void setFecha(Time fecha) {
		this.fecha = fecha;
	}

	public String getTextoPeticion() {
		return textoPeticion;
	}

	public void setTextoPeticion(String textoPeticion) {
		this.textoPeticion = textoPeticion;
	}
	
}
