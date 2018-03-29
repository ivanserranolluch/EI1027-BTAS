package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.model.PreferenciasService;
import es.uji.ei1027.btas.model.OfertaProyectoService;

public class PreferenciasController {
	
private PreferenciasService estudianteService;
	
	@Autowired
	public void set (PreferenciasService estudianteService){
		this.estudianteService = estudianteService;
	}
	

	@RequestMapping("/peritinerario")
	public String listClsfPerPais(Model model){
		model.addAttribute("classificacions", estudianteService.getPreferenciasEstudiante("paco"));
		return "preferencies/perEstudiante";
	}

}
