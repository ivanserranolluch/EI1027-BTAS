package ei.uji.ei1027.btas.services;

import java.util.List;
import java.util.Map;

import es.uji.ei1027.btas.model.Estudiante;
import es.uji.ei1027.btas.model.PreferenciasEstudiante;

public interface PreferenciasService {

	public List<PreferenciasEstudiante> getPreferenciasEstudiante(String estudiante_id);

	
}
