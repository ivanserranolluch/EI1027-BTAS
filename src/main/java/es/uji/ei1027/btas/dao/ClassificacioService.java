package es.uji.ei1027.btas.dao;

import java.util.List;
import java.util.Map;

import es.uji.ei1027.btas.model.Nadador;


public interface ClassificacioService {
	public Map<String, List<Nadador>> getClassificationByCountry(String prova);
}
