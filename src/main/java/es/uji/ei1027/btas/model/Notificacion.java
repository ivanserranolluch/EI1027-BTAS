package es.uji.ei1027.btas.model;

public class Notificacion {
	
	private int id;
	private PersonaContacto personaContacto;
	private String emailBBC;
	private String emailCCD;
	private String mensaje;
	
public Notificacion() {
	super();
}

public Notificacion(int id,PersonaContacto personaContacto,String emailBBC,String emailCCD, String mensaje) {

this.id=id;
this.personaContacto = personaContacto;
this.emailBBC = emailBBC;
this.emailCCD = emailCCD;
this.mensaje = mensaje;

}

public Notificacion(Notificacion notificacion) {
	this.id= notificacion.id;
	this.personaContacto = notificacion.personaContacto;
	this.emailBBC = notificacion.emailBBC;
	this.emailCCD = notificacion.emailCCD;
	this.mensaje = notificacion.mensaje;
	
}

}