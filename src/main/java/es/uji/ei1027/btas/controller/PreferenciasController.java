package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ei.uji.ei1027.btas.services.PreferenciasService;
import es.uji.ei1027.btas.dao.PreferenciasEstudianteDAO;


@Controller
@RequestMapping("/estudiante/preferenciasEstudiante")
public class PreferenciasController {
	
private PreferenciasService estudianteService;
private PreferenciasEstudianteDAO preferenciasEstudianteDao;
	
	@Autowired
	public void set (PreferenciasService estudianteService){
		this.estudianteService = estudianteService;
	}
	

	@RequestMapping("/peritinerario")
	public String listPrefPorEstudiante(Model model){
		model.addAttribute("classificacions", estudianteService.getPreferenciasEstudiante("paco"));
		return "preferencies/perEstudiante";
	}

}
