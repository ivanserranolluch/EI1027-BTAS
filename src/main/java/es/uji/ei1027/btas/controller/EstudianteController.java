package es.uji.ei1027.btas.controller;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.btas.dao.EstudianteDAO;
import es.uji.ei1027.btas.model.Estudiante;



@Controller
@RequestMapping("/estudiante")

public class EstudianteController {
	
	private EstudianteDAO estudianteDAO;
	
	@Autowired
	public void setEstudianteDAO (EstudianteDAO estudianteDAO){
		this.estudianteDAO = estudianteDAO;
	}
	
	//OPERACION LISTAR
	
			@RequestMapping("/list")
			public String listEstudiantes(Model model) {
				model.addAttribute("estudiantes", estudianteDAO.getEstudiantes());
				return "estudiante/list";
			}
			
			@RequestMapping("/listBTC")
			public String listEstudiantesBTC(Model model) {
				model.addAttribute("estudiantes", estudianteDAO.getEstudiantes());
				return "estudiante/listBTC";
			}
			
			@RequestMapping("/list2")
			public String listEstudiantes2(Model model) {
				model.addAttribute("estudiantes", estudianteDAO.getEstudiantes());
				return "estudiante/list2";
			}
			
			@RequestMapping("/listEstudiantesBTCAsignaciones")
			public String listEstudiantesBTCAsignaciones(Model model) {
				model.addAttribute("estudiantes", estudianteDAO.getEstudiantes());
				return "estudiante/listEstudiantesBTCAsignaciones";
			}
			
	//OPERACION CREAR
			
			@RequestMapping(value="/add")
			public String addEstudiante(Model model) {
				model.addAttribute("estudiante", new Estudiante());
				return "estudiante/add";
			}
			
			@RequestMapping(value="/add", method=RequestMethod.POST)
			public String processAddSubmit(@ModelAttribute("estudiante") Estudiante estudiante, BindingResult bindingResult){
				if (bindingResult.hasErrors()){
					System.out.println(bindingResult);
					return "estudiante/add";
					
				}
				estudianteDAO.addEstudiante(estudiante);
				return "redirect:list.html";
			}
			
			@RequestMapping(value="/update/{dni}", method=RequestMethod.GET)
			public String editEstudiante(Model model, @PathVariable String dni){
				
				model.addAttribute("estudiante", estudianteDAO.getEstudiante(dni));
				return "estudiante/update";
			}
			
			@RequestMapping(value="/update/{dni}", method=RequestMethod.POST)
			public String processUpdateSubmit(@PathVariable String dni, @ModelAttribute("estudiante") Estudiante estudiante, BindingResult bindingResult){
				if(bindingResult.hasErrors()){
					System.out.println(bindingResult.hasErrors());
					return "estudiante/update";
				}
				
		
				estudianteDAO.updateEstudiante(dni,estudiante.getAl(),estudiante.getNombre(),estudiante.getApellidos(),estudiante.getDescItinerario(),estudiante.getNotaMedia(),estudiante.getNumAsigPendiente(),estudiante.getNumCreditosAprobados(),estudiante.getSemestreInicioEstancia(),estudiante.getEmail(),estudiante.getTelefono());
				
				return "redirect:../list";
			}
			
	//OPERACION BORRAR
			
			@RequestMapping(value="/delete/{dni}")
			public String processDelete(@PathVariable String dni) {
				estudianteDAO.deleteEstudiante(dni);;
				return "redirect:../list";
			}
			
			@InitBinder
			public void initBinder(final WebDataBinder binder){
			  final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD"); 
			  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
			}


}
