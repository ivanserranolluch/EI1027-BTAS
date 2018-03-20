package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.dao.ClassificacioService;

public class ClassificacioController {
	
	private ClassificacioService classificacioService;
	
	@Autowired
	public void setClassificacioService(ClassificacioService classificacioService){
		this.classificacioService = classificacioService;
	}
	
	@RequestMapping("/perpais")
	public String listClsfPerPais(Model model){
		model.addAttribute("classificacions", classificacioService.getClassificationByCountry("Duos Sincro"));
		return "classificacio/perpais";
	}
	
}
