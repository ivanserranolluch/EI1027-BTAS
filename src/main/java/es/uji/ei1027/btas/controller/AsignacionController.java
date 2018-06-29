package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.dao.AsignacionDAO;
import es.uji.ei1027.btas.dao.AsignacionEmpresaTutorEstudianteDAO;


@Controller
@RequestMapping("/asignacion")
public class AsignacionController {
	
	private AsignacionDAO asignacionDAO;
	private AsignacionEmpresaTutorEstudianteDAO asignacionEmpresaTutorEstudianteDao;
	
	@Autowired
	public void setOfertaProyectoDAO (AsignacionDAO asignacionDAO,AsignacionEmpresaTutorEstudianteDAO asignacionEmpresaTutorEstudianteDao){
		this.asignacionDAO = asignacionDAO;
		this.asignacionEmpresaTutorEstudianteDao=asignacionEmpresaTutorEstudianteDao;
	}
	
	
	
	@RequestMapping("/add")
	public String listAsignacionaddlitar(Model model) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDao.getAsignacionCompleta());
		return "asignacion/add";
	}
	@RequestMapping("/listAsigModTutor")
	public String listAsignacionaddlitarTutor(Model model) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDao.getAsignacionCompleta());
		return "asignacion/listAsigModTutor";
	}
	
	@RequestMapping("/listar")
	public String listAsignacion(Model model) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignacion", asignacionDAO.getAsignacion());
		return "asignacion/listar";
	}
	@RequestMapping("/listarParaAnular")
	public String listAsignacionListarAnular(Model model) {
		System.out.println("entro en Asignaciones anular");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDao.getAsignacionCompleta());
		return "asignacion/listarParaAnular";
	}
	
	@RequestMapping("/listarAsignacionesEstudiante/{dniE}")
	public String listAsignacionEstudiante(Model model, @PathVariable String dniE) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDao.getAsignacionCompletaDniE(dniE));
		System.out.println("Salgo en Asignaciones");
		return "asignacion/listarAsignacionesEstudiante";
	}
	@RequestMapping("/listarAsignacionesEstudianteCCD/{dniE}")
	public String listAsignacionEstudianteCCD(Model model, @PathVariable String dniE) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDao.getAsignacionCompletaDniE(dniE));
		System.out.println("Salgo en Asignaciones");
		return "asignacion/listarAsignacionesEstudianteCCD";
	}

	@RequestMapping("/listarAsignacionesEstudianteBTC/{dniE}")
	public String listAsignacionEstudianteBTC(Model model, @PathVariable String dniE) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDao.getAsignacionCompletaDniE(dniE));
		System.out.println("Salgo en Asignaciones");
		return "asignacion/listarAsignacionesEstudianteBTC";
	}
	@RequestMapping("/listarAsignacionesEstudianteBTCRechazar/{dniE}")
	public String listAsignacionEstudianteBTCRechazar(Model model, @PathVariable String dniE) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDao.getAsignacionCompletaDniE(dniE));
		System.out.println("Salgo en Asignaciones");
		return "asignacion/listarAsignacionesEstudianteBTCRechazar";
	}
	
	@RequestMapping("/listarAsignacionesTutor/{dniT}")
	public String listAsignacionTutor(Model model, @PathVariable String dniT) {
		System.out.println("entro en Asignaciones");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDao.getAsignacionCompletaDniT(dniT));
		System.out.println("Salgo en Asignaciones");
		return "asignacion/listarAsignacionesTutor";
	}
	
}
