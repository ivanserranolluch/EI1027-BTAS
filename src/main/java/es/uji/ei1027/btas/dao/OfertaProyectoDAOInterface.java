package es.uji.ei1027.btas.dao;

import java.util.Date;
import java.util.List;

import es.uji.ei1027.btas.model.EstadoOferta;
import es.uji.ei1027.btas.model.Itinerario;
import es.uji.ei1027.btas.model.OfertaProyecto;

public interface OfertaProyectoDAOInterface {

	public List<OfertaProyecto> getOfertas();
	
	public OfertaProyecto getOfertaProyecto(int id);
	
	public void addOferta(OfertaProyecto ofertaProyecto);
	
	public void updateOfertaProyectoEstado(int id,String estado);
	
	public void updateOfertaProyecto(int id, String estado, String itinerario, Date fechaAlta, String objetvio, String tarea);
	
	public void deleteOferta(int id);
	
	public List<OfertaProyecto> getItinerario(Itinerario itinerario);
}
