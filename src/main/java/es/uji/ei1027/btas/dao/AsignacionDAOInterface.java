package es.uji.ei1027.btas.dao;

import java.util.Date;
import java.util.List;

import es.uji.ei1027.btas.model.Asignacion;
import es.uji.ei1027.btas.model.EstadoAsignacion;


public interface AsignacionDAOInterface {
	
	//Lista todas las asignaciones dependiendo del estado.
	public List<Asignacion> getAsignacion();
	
	//Muestra la asignacion del estudiante.
	public Asignacion getAsignacionEstudiante(String dniE);
	
	//Añade una asignacion.
	public void addAsignacion(Asignacion asignacion);
	
	//Modifica la asignacion por estado.
	public void updateAsignacionEstado(int id,String estado);
	
	public void updateAsignacion();
	
	public void deleteAsignacion(int id);
	
	public List<Asignacion> getEstado(EstadoAsignacion estadoAsignacion);
}
