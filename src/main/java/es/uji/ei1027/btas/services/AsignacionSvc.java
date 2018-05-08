package es.uji.ei1027.btas.services;

import java.util.List;

import es.uji.ei1027.btas.dao.AsignacionDAO;
import es.uji.ei1027.btas.model.Asignacion;
import es.uji.ei1027.btas.model.EstadoAsignacion;


public class AsignacionSvc implements AsignacionService{
	
	AsignacionDAO asignacionDao;

	@Override
	public List<Asignacion> getAsignacion() {
		
		List<Asignacion> listaAsignacion= asignacionDao.getAsignacion();
		
		return listaAsignacion;
	}

	@Override
	public List<Asignacion> getAsignacionEstado(EstadoAsignacion estadoAsignacion) {
		
		List<Asignacion> listaAsignacionEstado= asignacionDao.getEstado(estadoAsignacion);
		
		return listaAsignacionEstado;
	}

}
