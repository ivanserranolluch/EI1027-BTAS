package es.uji.ei1027.btas.dao;

import java.util.Date;
import java.util.List;

import es.uji.ei1027.btas.model.Estancia;
import es.uji.ei1027.btas.model.Itinerario;


public interface EstanciaDAOInterface {

	public List<Estancia> getEstancias();
	
	
	public void addEstancia(Estancia estancia);
	
	public void updateOfertaProyectoEstado(int id,String estado);
	
	public void updateOfertaProyecto(int id, String estado, String itinerario, int id_estancia, Date fechaAlta, String objetvio, String tarea);
	
	public void deleteEstancia(int id);
	
	
	
}
