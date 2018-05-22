package es.uji.ei1027.btas.dao;


import java.util.List;

import es.uji.ei1027.btas.model.Estancia;



public interface EstanciaDAOInterface {

	public List<Estancia> getEstancias();
	
	public void addEstancia(Estancia estancia);
	
	public void deleteEstancia(int id_estancia);
	
	public void updateEstancia(int id_estancia, String descripcion, String dni, String cif);
	
	public Estancia getEstancia(int id_estancia);

}
