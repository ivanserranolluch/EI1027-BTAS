package ei.uji.ei1027.btas.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import es.uji.ei1027.btas.dao.ClassificacioDao;
import es.uji.ei1027.btas.dao.ClassificacioService;
import es.uji.ei1027.btas.dao.NadadorDAO;
import es.uji.ei1027.btas.model.Classificacio;
import es.uji.ei1027.btas.model.Nadador;

public class ClassificacioSvc implements ClassificacioService {
	
	@Autowired
	NadadorDAO nadadorDao;
	
	@Autowired
	ClassificacioDao classificacioDao;
	
	@Override
	public Map<String, List<Nadador>> getClassificationByCountry(String prova) {
		List<Classificacio> classProva = classificacioDao.getClassificacioProva(prova);
		HashMap<String, List<Nadador>> nadadorsPerPais = new HashMap<>();
		for (Classificacio clsf : classProva){
			Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());
			if (!nadadorsPerPais.containsKey(nadador.getPais()))
				nadadorsPerPais.put(nadador.getPais(),new ArrayList<Nadador>());
				nadadorsPerPais.get(nadador.getPais()).add(nadador);
		}
		return nadadorsPerPais;
	}
	
	public Map<String, List<Nadador>> getCountry(String pais) {
		List<Classificacio> classPais = classificacioDao.getClassificacioProva(pais);
		HashMap<String, List<Nadador>> nadadorsPerProva = new HashMap<>();
		for (Classificacio clsf : classPais){
			Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());
			if (!nadadorsPerProva.containsKey(nadador.getPais()))
				nadadorsPerProva.put(nadador.getPais(),new ArrayList<Nadador>());
				nadadorsPerProva.get(nadador.getPais()).add(nadador);
		}
		return nadadorsPerProva;
	}

}
