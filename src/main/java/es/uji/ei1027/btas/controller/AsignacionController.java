package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.dao.AsignacionDAO;


@Controller
@RequestMapping("/asignacion")
public class AsignacionController {
	
	private AsignacionDAO asignacionDAO;
	
	@Autowired
	public void setOfertaProyectoDAO (AsignacionDAO asignacionDAO){
		this.asignacionDAO = asignacionDAO;
	}
	
	@RequestMapping("/listar")
	public String listAsignacion(Model model) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignacion", asignacionDAO.getAsignacion());
		return "asignacion/listar";
	}
	
	@RequestMapping("/listarAsignacionesEstudiante/{dniE}")
	public String listAsignacionEstudiante(Model model, @PathVariable String dniE) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionDAO.getAsignacionEstudiante(dniE));
		System.out.println("Salgo en Asignaciones");
		return "asignacion/listarAsignacionesEstudiante";
	}

	@RequestMapping("/listarAsignacionesEstudianteBTC/{dniE}")
	public String listAsignacionEstudianteBTC(Model model, @PathVariable String dniE) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionDAO.getAsignacionEstudiante(dniE));
		System.out.println("Salgo en Asignaciones");
		return "asignacion/listarAsignacionesEstudianteBTC";
	}
	
	@RequestMapping("/listarAsignacionesTutor/{dniT}")
	public String listAsignacionTutor(Model model, @PathVariable String dniT) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionDAO.getAsignacionesTutor(dniT));
		System.out.println("Salgo en Asignaciones");
		return "asignacion/listarAsignacionesTutor";
	}
	
}
