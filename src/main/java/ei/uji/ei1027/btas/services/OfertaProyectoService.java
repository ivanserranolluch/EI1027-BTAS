package ei.uji.ei1027.btas.services;

import java.util.List;

import es.uji.ei1027.btas.model.OfertaProyecto;


public interface OfertaProyectoService {
	 
		public List<OfertaProyecto> getOfertas();
		public  List<OfertaProyecto> getOfertasItinerario(String itinerario);
	

}
