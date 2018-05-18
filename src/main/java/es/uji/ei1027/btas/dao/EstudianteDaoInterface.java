package es.uji.ei1027.btas.dao;

import java.util.List;
import es.uji.ei1027.btas.model.Estudiante;
import es.uji.ei1027.btas.model.Itinerario;


public interface EstudianteDaoInterface {
	
	public List<Estudiante> getEstudiantes();
	
	public Estudiante getEstudiante(int al);
	
	public void addEstudiante(Estudiante estudiante);
	
	public void updateEstudianteSemestreInicio(int id,int semestreInicioEstancia);
	
	public void updateEstudiante(String dni,String al,String nombre, String apellidos,int telefono,
	String email, String itinerario, double notaMedia, int numAsigPendiente,int numCreditosAprobados,int semestreInicioEstancia);
	
	public void deleteEstudiante(int al);
	
	public List<Estudiante> getItinerario(Itinerario itinerario);

}
