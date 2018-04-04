package ei.uji.ei1027.btas.services;




import org.springframework.beans.factory.annotation.Autowired;


import es.uji.ei1027.btas.dao.EstudianteDAO;

import es.uji.ei1027.btas.dao.PreferenciasEstudianteDAO;


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
