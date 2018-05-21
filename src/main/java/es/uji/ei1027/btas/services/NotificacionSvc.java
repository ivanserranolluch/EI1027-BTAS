package es.uji.ei1027.btas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uji.ei1027.btas.dao.EstudianteDAO;
import es.uji.ei1027.btas.dao.NotificacionDAO;
import es.uji.ei1027.btas.dao.PreferenciasEstudianteDAO;
import es.uji.ei1027.btas.model.Estudiante;
import es.uji.ei1027.btas.model.Notificacion;
import es.uji.ei1027.btas.model.PreferenciasEstudiante;

@Service
public class NotificacionSvc implements NotificacionService{
	
	@Autowired
	EstudianteDAO estudianteDao;
	
	@Autowired
	NotificacionDAO notificacionDao;
	
	
	@Override
	public void notificaEstudiantes(int id) {
		List<Estudiante> listaEstudiantes = estudianteDao.getEstudiantes();

		for (Estudiante est : listaEstudiantes){
			Notificacion notificacion = new Notificacion(id,est.getDni());
			notificacionDao.addNotificacion(notificacion);
		}
	
		}
	
	

}
