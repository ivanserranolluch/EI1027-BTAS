package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.btas.dao.PersonaContactoDAO;
import es.uji.ei1027.btas.model.OfertaProyecto;
import es.uji.ei1027.btas.model.PersonaContacto;

@Controller
@RequestMapping("/personaContacto")
public class PersonaContactoController{

	private PersonaContactoDAO personaContactoDAO;
	
	@Autowired
	public void setPersonaContactoDAO (PersonaContactoDAO personaContactoDAO){
		this.personaContactoDAO = personaContactoDAO;
	}
	
	
	//LISTAR PERSONAS CONTACTO
	@RequestMapping("/list")
	public String listPersonaContacto(Model model) {
		model.addAttribute("personaContactoList", personaContactoDAO.getPersonaContactos());
		return "personaContacto/list";
	}
	
	
	
	
	//BORRAR PERSONA CONTACTO
	@RequestMapping(value="/delete/{dni}")
	public String processDelete(@PathVariable String dni) {
		personaContactoDAO.deletePersonaContacto(dni);
		return "redirect:../list";
	}
	
	
	
	
	//MODIFICAR PERSONA CONTACTO
	@RequestMapping(value="/update/{dni}", method=RequestMethod.GET)
	public String editPersonaContacto(Model model, @PathVariable String dni){
		
		model.addAttribute("personaContacto",personaContactoDAO.getPersonaContacto(dni));
		return "personaContacto/update";
	}
	
	@RequestMapping(value="/update/{dni}", method=RequestMethod.POST)
	public String processUpdateSubmit(@PathVariable String dni, @ModelAttribute("personaContacto") PersonaContacto personaContacto, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.hasErrors());
			return "personaContacto/update";
		}
		

		personaContactoDAO.updatePersonaContacto(dni, personaContacto.getCif());
		return "redirect:../list";
	}
	
	
	
	
	//AÑADIR PERSONA CONTACTO
	@RequestMapping(value="/add")
	public String addPersonaContacto(Model model) {
		model.addAttribute("personaContacto", new PersonaContacto());
		return "personaContacto/add";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddSubmit(@ModelAttribute("personaContacto")PersonaContacto personaContacto, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			System.out.println(bindingResult);
			return "personaContacto/add";
			
		}
		personaContactoDAO.addPersonaContacto(personaContacto);
		return "redirect:list.html";
	}
}