package es.uji.ei1027.btas.model;

public class NotificacionAsignacion extends Notificacion {
	
	private Estudiante estudiante;
	private Tutor tutor;
	
	public NotificacionAsignacion() {
		super();
	}
	
	public NotificacionAsignacion(int id,PersonaContacto personaContacto,String emailBBC,
			String emailCCD, String mensaje, Estudiante estudiante, Tutor tutor) {
		super(id, personaContacto,emailBBC,emailCCD,mensaje);
		this.estudiante = estudiante;
		this.tutor = tutor;
	}
	public NotificacionAsignacion(NotificacionAsignacion notificacionAsignacion) {
		super(notificacionAsignacion);
		this.estudiante = notificacionAsignacion.estudiante;
		this.tutor = notificacionAsignacion.tutor;
		
	}
}
