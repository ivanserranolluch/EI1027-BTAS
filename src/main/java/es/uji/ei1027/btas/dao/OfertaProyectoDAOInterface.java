package es.uji.ei1027.btas.dao;

import java.util.List;

import es.uji.ei1027.btas.model.EstadoOferta;
import es.uji.ei1027.btas.model.OfertaProyecto;

public interface OfertaProyectoDAOInterface {

	public List<OfertaProyecto> getOfertas();
	
	public OfertaProyecto getOfertaProyecto(String id);
	
	public void addOferta(OfertaProyecto ofertaProyecto);
	
	public void updateOfertaProyecto(int id,EstadoOferta estado);
	
	public void deleteOferta(int id);
	
	public List<OfertaProyecto> getItinerario(String itinerario);
}
