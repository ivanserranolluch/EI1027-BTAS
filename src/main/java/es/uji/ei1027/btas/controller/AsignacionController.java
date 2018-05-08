package es.uji.ei1027.btas.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.dao.AsignacionDAO;
import es.uji.ei1027.btas.model.Asignacion;

public class AsignacionController {
	
	private AsignacionDAO asignacionDAO;
	
	public void setAsignacionDAO(AsignacionDAO asignacionDAO) {
		this.asignacionDAO=asignacionDAO;
	}
	
	//OPERACION AÑADIR
	
	@RequestMapping(value="/add")
	public String addAsignacion(Model model) {
		model.addAttribute("asignacion",new Asignacion());
		return "asignacion/add";
		
	}
	
	

}
