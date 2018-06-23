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
import es.uji.ei1027.btas.dao.TutorDAO;
import es.uji.ei1027.btas.model.Estudiante;
import es.uji.ei1027.btas.model.Tutor;

@Controller
@RequestMapping("/tutor")
public class TutorController {
	
	private TutorDAO tutorDAO;
	
	@Autowired
	public void setTutorDAO (TutorDAO tutorDAO){
		this.tutorDAO = tutorDAO;
	}

	//OPERACION LISTAR
	@RequestMapping("/list")
	public String listTutores(Model model) {
		model.addAttribute("tutores", tutorDAO.getTutores());
		return "tutor/list";
	}

	
	//OPERACION CREAR
	
	@RequestMapping(value="/add")
	public String addTutor(Model model) {
		model.addAttribute("tutor", new Tutor());
		return "tutor/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddSubmit(@ModelAttribute("tutor") Tutor tutor, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			System.out.println(bindingResult);
			return "tutor/add";
			
		}
		tutorDAO.addTutor(tutor);
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/update/{dni}", method=RequestMethod.GET)
	public String editTutor(Model model, @PathVariable String dni){
		
		model.addAttribute("tutor", tutorDAO.getTutor(dni));
		return "tutor/update";
	}
	
	@RequestMapping(value="/update/{dni}", method=RequestMethod.POST)
	public String processUpdateSubmit(@PathVariable String dni, @ModelAttribute("tutor") Tutor tutor, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.hasErrors());
			return "tutor/update";
		}
		

		tutorDAO.updateTutor(dni,tutor.getDireccion(),tutor.getNombre(),tutor.getTelefono(),tutor.getEmail(),tutor.getDepartamento(),tutor.getDespacho());
		
		return "redirect:../list";
	}
	
	//OPERACION BORRAR
	
	@RequestMapping(value="/delete/{dni}")
	public String processDelete(@PathVariable String dni) {
		tutorDAO.deleteTutor(dni);;
		return "redirect:../list";
	}
	
	/*@InitBinder
	public void initBinder(final WebDataBinder binder){
	  final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD"); 
	  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}*/
}
