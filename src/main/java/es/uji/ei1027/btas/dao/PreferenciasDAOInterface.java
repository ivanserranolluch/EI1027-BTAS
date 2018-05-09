package es.uji.ei1027.btas.dao;

import java.util.List;


import es.uji.ei1027.btas.model.PreferenciasEstudiante;

public interface PreferenciasDAOInterface {
	
	public List<PreferenciasEstudiante> getPreferencias();
	
	public List<PreferenciasEstudiante> getPreferenciaEstudiante(String dni);
	
	public PreferenciasEstudiante getPreferencia(int id);
	
	
	public void addPrefereciaEstudiante(PreferenciasEstudiante preferenciaEstudiante);
	
	public void updatePreferenciaEstudiante(int id,int orden,String estado,String fechaUltimoCambio);
	
	public void deletePreferenciaEstudiante(int id);
	
//	public List<PreferenciasEstudiante> getIEstudiante(String dni);

}
