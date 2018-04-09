package es.uji.ei1027.btas.services;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import es.uji.ei1027.btas.dao.EstudianteDAO;

import es.uji.ei1027.btas.dao.PreferenciasEstudianteDAO;
import es.uji.ei1027.btas.model.Estudiante;
import es.uji.ei1027.btas.model.PreferenciasEstudiante;


public class PreferenciasEstudianteSvc implements PreferenciasService{
	
	@Autowired
	EstudianteDAO estudianteDao;
	
	@Autowired
	PreferenciasEstudianteDAO preferenciasEstudianteDao;
	
	
	@Override
	public List<PreferenciasEstudiante> getPreferenciasEstudiante(String id) {
		List<PreferenciasEstudiante> listaPreferencias = preferenciasEstudianteDao.getOfertaDePreferencies("id");
		//HashMap<String, List<Nadador>> nadadorsPerPais = new HashMap<>();
		/*for (PreferenciasEstudiante clsf : listaPreferencias){
			Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());
			if (!nadadorsPerPais.containsKey(nadador.getPais()))
				nadadorsPerPais.put(nadador.getPais(),new ArrayList<Nadador>());
				nadadorsPerPais.get(nadador.getPais()).add(nadador);
		}*/
		return listaPreferencias;
	}

}
