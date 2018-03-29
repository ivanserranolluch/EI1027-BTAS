package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.model.OfertaProyectoService;



public class OfertaProyectoController {
	
private OfertaProyectoService ofertaProyectoService;
	
	@Autowired
	public void set (OfertaProyectoService classificacioService){
		this.ofertaProyectoService = classificacioService;
	}
	

	@RequestMapping("/peritinerario")
	public String listClsfPerPais(Model model){
		model.addAttribute("classificacions", ofertaProyectoService.getOfertasItinerario("INGENIERA_SOFTWARE"));
		return "classificacio/perpais";
	}

}
