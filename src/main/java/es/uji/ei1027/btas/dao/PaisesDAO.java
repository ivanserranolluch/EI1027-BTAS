package es.uji.ei1027.btas.dao;

import java.util.List;

public interface PaisesDAO {
	
	List<Pais> getPaises();
	
	Pais getPais(String nom);

	void addPais(Pais pais);

	void updatePais(Pais pais);

	void deletePais(Pais pais);

}
