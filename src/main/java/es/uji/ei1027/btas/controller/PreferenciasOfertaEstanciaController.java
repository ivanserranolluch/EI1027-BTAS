package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import es.uji.ei1027.btas.dao.PreferenciasOfertaEstanciaDAO;

@Controller
@RequestMapping("/preferenciasOfertaEstancia")

public class PreferenciasOfertaEstanciaController {
	private PreferenciasOfertaEstanciaDAO preferenciasOfertaEstanciaDao;
	
	
	@Autowired
	public void setPreferenciasOfertaEstanciaDAO (PreferenciasOfertaEstanciaDAO preferenciasOfertaEstanciaDao){
		this.preferenciasOfertaEstanciaDao = preferenciasOfertaEstanciaDao;
	}
	
	//OPERACION LISTAR
	
	
	@RequestMapping("/listar")
	public String listPreferenciasEstudiante(Model model) {
		System.out.println("He entrado");
		model.addAttribute("preferencias", preferenciasOfertaEstanciaDao.getPreferenciaOfertaEstancia());
		System.out.println("entro en la lista de preferencias del estudiante CCD");
		System.out.println("Aqio tmbien joder");
		return "preferenciasOfertaEstancia/listar";
		
	}
	
	
	
}
