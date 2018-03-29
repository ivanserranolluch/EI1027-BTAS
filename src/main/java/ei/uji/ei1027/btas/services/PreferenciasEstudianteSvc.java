package ei.uji.ei1027.btas.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import es.uji.ei1027.btas.dao.ClassificacioDao;
import es.uji.ei1027.btas.dao.EstudianteDAO;
import es.uji.ei1027.btas.dao.NadadorDAO;
import es.uji.ei1027.btas.dao.PreferenciasEstudianteDAO;
import es.uji.ei1027.btas.model.PreferenciasEstudiante;
import es.uji.ei1027.btas.model.Estudiante;
import es.uji.ei1027.btas.model.Nadador;

public class PreferenciasEstudianteSvc {
	
	@Autowired
	EstudianteDAO estudianteDao;
	
	@Autowired
	PreferenciasEstudianteDAO preferenciasEstudianteDao;
	
	/*
	@Override
	public Map<String, List<Estudiante>> getClassificationByCountry(String id) {
		List<PreferenciasEstudiante> classProva = preferenciasEstudianteDao.getOfertaDePreferencies("id");
		HashMap<String, List<Nadador>> nadadorsPerPais = new HashMap<>();
		for (PreferenciasEstudiante clsf : classProva){
			Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());
			if (!nadadorsPerPais.containsKey(nadador.getPais()))
				nadadorsPerPais.put(nadador.getPais(),new ArrayList<Nadador>());
				nadadorsPerPais.get(nadador.getPais()).add(nadador);
		}
		return nadadorsPerPais;
	}
*/
}
