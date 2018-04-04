package es.uji.ei1027.btas.model;

public class NotificacionAsignacion extends Notificacion {
	
	private Estudiante estudiante;
	private Tutor tutor;
	private OfertaProyecto ofertaProyecto;
	
	public NotificacionAsignacion() {
		super();
	}
	
	public NotificacionAsignacion(int id,Estudiante estudiante,OfertaProyecto ofertaProyecto,PersonaContacto personaContacto,String emailBBC,
			String emailCCD, String mensaje, Tutor tutor) {
		super(id, personaContacto,emailBBC,emailCCD,mensaje);
		this.estudiante = estudiante;
		this.ofertaProyecto= ofertaProyecto;
		this.tutor = tutor;
	}
	public NotificacionAsignacion(NotificacionAsignacion notificacionAsignacion) {
		super(notificacionAsignacion);
		this.estudiante = notificacionAsignacion.estudiante;
		this.tutor = notificacionAsignacion.tutor;
		this.ofertaProyecto= notificacionAsignacion.ofertaProyecto;
		
	}
	public String SendMessage(String id) {
		return "la oferta con id" + id +"ya ha sido asignada";
	}
}
