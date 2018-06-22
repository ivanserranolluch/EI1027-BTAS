package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.dao.PreferenciasOfertaDAO;

@Controller
@RequestMapping("/preferenciasOferta")

public class PreferenciasOfertaController {
	private PreferenciasOfertaDAO preferenciasOfertaDao;
	
	
	@Autowired
	public void setPreferenciasOfertaDAO (PreferenciasOfertaDAO preferenciasOfertaDao){
		this.preferenciasOfertaDao = preferenciasOfertaDao;
	}
	
	//OPERACION LISTAR
	
	
	@RequestMapping("/listar")
	public String listPreferenciasEstudiante(Model model) {
		System.out.println("He entrado");
		model.addAttribute("preferencias", preferenciasOfertaDao.getPreferenciaOferta());
		System.out.println("entro en la lista de preferencias del estudiante CCD");
		System.out.println("Aqio tmbien joder");
		return "preferenciasOferta/listar";
		
	}
	
	@RequestMapping("/listBTC/{dni}")
	public String listPreferenciasEstudianteOferta(Model model, @PathVariable("dni") String dni) {
		System.out.println("He entrado");
		model.addAttribute("preferencias", preferenciasOfertaDao.getPreferenciaOfertaDNI(dni));
		System.out.println("entro en la lista de preferencias del estudiante CCD");
		System.out.println("Aqio tmbien joder");
		return "preferenciasOferta/listBTC";
		
	}
	
	
}
