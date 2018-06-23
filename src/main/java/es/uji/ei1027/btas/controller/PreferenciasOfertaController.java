package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.dao.AsignacionDAO;
import es.uji.ei1027.btas.dao.AsignacionEmpresaTutorEstudianteDAO;
import es.uji.ei1027.btas.dao.PreferenciasOfertaDAO;
import es.uji.ei1027.btas.dao.TutorDAO;
import es.uji.ei1027.btas.services.AsignacionEmpresaTutorEstudianteService;

@Controller
@RequestMapping("/preferenciasOferta")

public class PreferenciasOfertaController {
	private PreferenciasOfertaDAO preferenciasOfertaDao;
	private TutorDAO tutorDAO;
	private AsignacionDAO asignacionDAO;
	private AsignacionEmpresaTutorEstudianteDAO asignacionEmpresaTutorEstudianteDAO;
	
	private AsignacionEmpresaTutorEstudianteService asignacionEmpresaTutorEstudianteService;
	@Autowired
	public void setPreferenciasOfertaDAO (PreferenciasOfertaDAO preferenciasOfertaDao, TutorDAO tutorDao, AsignacionDAO asignacionDAO,AsignacionEmpresaTutorEstudianteDAO asignacionEmpresaTutorEstudianteDAO){
		this.preferenciasOfertaDao = preferenciasOfertaDao;
		this.tutorDAO=tutorDao;
		this.asignacionDAO=asignacionDAO;
		this.asignacionEmpresaTutorEstudianteDAO=asignacionEmpresaTutorEstudianteDAO;
		//this.asignacionEmpresaTutorEstudianteDAO=asignacionEmpresaTutorEstudianteDAO;
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
		model.addAttribute("tutores", tutorDAO.getTutores());
		System.out.println("Aqio tmbien joder");
		return "preferenciasOferta/listBTC";
		
	}
	
	@RequestMapping("/listBTC/{dni}/tutor/listBTC/{id}")
	public String listTutoresBTCAsig(Model model, @PathVariable("dni") String dniEstudiante, @PathVariable("id") int id_oferta) {
		System.out.println("Entro en la lista de tutores");
		model.addAttribute("dni", dniEstudiante);
		model.addAttribute("id", id_oferta);
		model.addAttribute("prefernacias", preferenciasOfertaDao.getPreferenciaOferta());
		model.addAttribute("tutores", tutorDAO.getTutores());
		System.out.println("Salgo lista tutores");
		return "tutor/listBTC";
	}
	
	@RequestMapping("/listBTC/{dni}/tutor/listBTC/{id}/asignacion/add/{dniT}")
	public String listTutoresAddAsignacion(Model model, @PathVariable("dni") String dniEstudiante, @PathVariable("id") int id_oferta,@PathVariable("dniT") String dniT) {
		System.out.println("Entro en el añadir asignacion");
		model.addAttribute("dni", dniEstudiante);
		model.addAttribute("id", id_oferta);
		model.addAttribute("dniT", dniT);
		asignacionDAO.addAsignacion(id_oferta,dniEstudiante,dniT);
		//model.addAttribute("asignaciones", asignacionDAO.getAsignacion());
		System.out.println("Ya he insertado en asig");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDAO.getAsignacionCompleta());
		
		System.out.println("Salgo");
		return "asignacion/add";
	}
	
}
