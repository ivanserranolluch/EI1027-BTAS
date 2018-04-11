package es.uji.ei1027.btas.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uji.ei1027.btas.dao.EstudianteDAO;
import es.uji.ei1027.btas.dao.OfertaProyectoDAO;
import es.uji.ei1027.btas.model.Itinerario;
import es.uji.ei1027.btas.model.OfertaProyecto;

@Service
public class OfertaProyectoSvc implements OfertaProyectoService{

	/*@Autowired
	EstudianteDAO estudianteDao;*/
	
	@Autowired
	OfertaProyectoDAO ofertaProyectoDao;
	
	
	public List<OfertaProyecto> getOfertas() {
		
		List<OfertaProyecto> listaOfertas= ofertaProyectoDao.getOfertas();
		
		return listaOfertas;
		
	}
	public List<OfertaProyecto> getOfertasItinerario(Itinerario itinerario) {
		
		List<OfertaProyecto> listaProyectoItinerario= ofertaProyectoDao.getItinerario(itinerario);
		
		return listaProyectoItinerario;
		
	}
	
	
	
}
