package es.uji.ei1027.btas.services;

import java.util.List;

import es.uji.ei1027.btas.model.Asignacion;
import es.uji.ei1027.btas.model.EstadoAsignacion;


public interface AsignacionService {

	public List<Asignacion> getAsignacion();
	public  List<Asignacion> getAsignacionEstado(EstadoAsignacion estadoAsignacion);
}
