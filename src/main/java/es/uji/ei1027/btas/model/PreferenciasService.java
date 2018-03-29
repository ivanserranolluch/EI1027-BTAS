package es.uji.ei1027.btas.model;

import java.util.List;
import java.util.Map;

public interface PreferenciasService {

	public Map<String, List<PreferenciasEstudiante>> getPreferenciasEstudiante(String estudiante_id);

	
}
