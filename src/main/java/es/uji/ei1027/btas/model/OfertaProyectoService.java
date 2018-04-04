package es.uji.ei1027.btas.model;

import java.util.List;


public interface OfertaProyectoService {
	 
		public List<OfertaProyecto> getOfertas();
		public  List<OfertaProyecto> getOfertasItinerario(String itinerario);
	

}
