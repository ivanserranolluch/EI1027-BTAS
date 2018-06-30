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
	@RequestMapping(value="/listarParaEstudiantes/{dni}")
	public String listPreferenciasEstudiante(Model model, @PathVariable String dni) {
		System.out.println(dni+"4");
		
		model.addAttribute("preferencias", preferenciasOfertaDao.getPreferenciaOfertaDNI(dni));
		System.out.println("entro en la lista de preferencias del estudiante");
		return "preferenciasOferta/listarParaEstudiantes";
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
	
	@RequestMapping("/listarPreferenciasEstudiante/{dni}")
	public String listPreferenciasEstudianteOfertaE(Model model, @PathVariable("dni") String dni) {
		System.out.println("He entrado");
		model.addAttribute("preferencias", preferenciasOfertaDao.getPreferenciaOfertaDNI(dni));
		System.out.println("entro en la lista de preferencias del estudiante CCD");
		
		System.out.println("Aqio tmbien joder");
		return "preferenciasOferta/listarPreferenciasEstudiante";
		
	}
	@RequestMapping("/listarPreferenciasEstudianteCCD/{dni}")
	public String listPreferenciasEstudianteOfertaECCD(Model model, @PathVariable("dni") String dni) {
		System.out.println("He entrado");
		model.addAttribute("preferencias", preferenciasOfertaDao.getPreferenciaOfertaDNI(dni));
		System.out.println("entro en la lista de preferencias del estudiante CCD");
		
		System.out.println("Aqio tmbien joder");
		return "preferenciasOferta/listarPreferenciasEstudianteCCD";
		
	}
	
	@RequestMapping("/listBTCRechazar/{dni}")
	public String listPreferenciasEstudianteOfertaRechazar(Model model, @PathVariable("dni") String dni) {
		System.out.println("He entrado");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDAO.getAsignacionCompletaDniEAceptada(dni));
		System.out.println("entro en la lista de preferencias del estudiante CCD");
		System.out.println("Aqio tmbien joder");
		return "asignacion/listarAsignacionesEstudianteBTCRechazar";
		
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
	
	@RequestMapping("/listBTCRechazar/{dni}/tutor/listBTCRechazar/{id}")
	public String listTutoresBTCAsigRechazar(Model model, @PathVariable("dni") String dniEstudiante, @PathVariable("id") int id_oferta) {
		System.out.println("Entro en la lista de tutores");
		model.addAttribute("dni", dniEstudiante);
		model.addAttribute("id", id_oferta);
		model.addAttribute("prefernacias", preferenciasOfertaDao.getPreferenciaOferta());
		model.addAttribute("tutores", tutorDAO.getTutores());
		System.out.println("Salgo lista tutores");
		return "tutor/listBTCRechazar";
	}
	
	@RequestMapping("/listBTC/{dni}/tutor/listBTC/{id}/asignacion/add/{dniT}")
	public String listTutoresAddAsignacion(Model model, @PathVariable("dni") String dniEstudiante, @PathVariable("id") int id_oferta,@PathVariable("dniT") String dniT) {
		System.out.println("Entro en el añadir asignacion");
		model.addAttribute("dni", dniEstudiante);
		model.addAttribute("id", id_oferta);
		model.addAttribute("dniT", dniT);
		
		//Controlamos que ya hayamos introducido la asignacion
		if(false==asignacionDAO.addAsignacion(id_oferta,dniEstudiante,dniT)) {
			return "asignacion/errorPrimaryKey";
		}
		//asignacionDAO.addAsignacion(id_oferta,dniEstudiante,dniT);
		//model.addAttribute("asignaciones", asignacionDAO.getAsignacion());
		System.out.println("Ya he insertado en asig");
		
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDAO.getAsignacionCompleta());
		
		System.out.println("Salgo");
		return "asignacion/add";
	}
	@RequestMapping("/listBTCRechazar/{dni}/tutor/listBTCRechazar/{id}/asignacion/rechazar/{dniT}")
	public String listTutoresAddAsignacionRechazar(Model model, @PathVariable("dni") String dniEstudiante, @PathVariable("id") int id_oferta,@PathVariable("dniT") String dniT) {
		System.out.println("Entro en el añadir asignacion");
		model.addAttribute("dni", dniEstudiante);
		model.addAttribute("id", id_oferta);
		model.addAttribute("dniT", dniT);
		asignacionDAO.anulaAsignacion(id_oferta,dniEstudiante,dniT);
		//model.addAttribute("asignaciones", asignacionDAO.getAsignacion());
		System.out.println("Ya he insertado en asig");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDAO.getAsignacionCompleta());
		
		System.out.println("Salgo");
		return "asignacion/add";
	}
	
	@RequestMapping("/listAsigModTutor/{dni}/tutor/elegir/{id}/asignacion/mod/{dniT}")
	public String listTutoresAddAsignacionModificar(Model model, @PathVariable("dni") String dniEstudiante, @PathVariable("id") int id_oferta,@PathVariable("dniT") String dniT) {
		System.out.println("Entro en el añadir asignacion");
		model.addAttribute("dni", dniEstudiante);
		model.addAttribute("id", id_oferta);
		model.addAttribute("dniT", dniT);
		//model.addAttribute("asignaciones", asignacionDAO.getAsignacion());
		System.out.println("Ya he insertado en asig");
		model.addAttribute("tutores", tutorDAO.getTutores());
		
		System.out.println("Salgo");
		return "tutor/listModAsig";
	}
	
	@RequestMapping("/listBTCMod/{dni}/tutor/{id}/asignacion/mod/{dniT}")
	public String listTutoresAddAsignacionModificar2(Model model, @PathVariable("dni") String dniEstudiante, @PathVariable("id") int id_oferta,@PathVariable("dniT") String dniT) {
		System.out.println("Entro en el añadir asignacion");
		model.addAttribute("dni", dniEstudiante);
		model.addAttribute("id", id_oferta);
		model.addAttribute("dniT", dniT);
		//model.addAttribute("asignaciones", asignacionDAO.getAsignacion());
		asignacionDAO.updateTutor(id_oferta,dniEstudiante,dniT);
		System.out.println("Ya he insertado en asig");
		model.addAttribute("asignaciones", asignacionEmpresaTutorEstudianteDAO.getAsignacionCompleta());
		
		System.out.println("Salgo");
		return "asignacion/add";
	}
	
}
