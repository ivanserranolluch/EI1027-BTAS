package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.dao.PreferenciasEstudianteDAO;
import es.uji.ei1027.btas.services.PreferenciasEstudianteService;


@Controller
@RequestMapping("/preferenciasEstudiante")
public class PreferenciasEstudianteController {
	
private PreferenciasEstudianteService estudianteService;
//private PreferenciasEstudianteDAO preferenciasEstudianteDao;
	
	@Autowired
	public void set (PreferenciasEstudianteService estudianteService){
		this.estudianteService = estudianteService;
	}
	

	/*@RequestMapping("/peritinerario")
	public String listPrefPorEstudiante(Model model){
		model.addAttribute("classificacions", estudianteService.getPreferenciasEstudiante("paco"));
		return "preferencies/perEstudiante";
	}*/

}
