package es.uji.ei1027.btas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.btas.dao.NadadorDAO;
import es.uji.ei1027.btas.model.Nadador;

@Controller
@RequestMapping("/nadador")
public class NadadorController {
	
	private NadadorDAO nadadorDAO;
	
	public void setNadadorDAO(NadadorDAO nadadorDAO){
		this.nadadorDAO = nadadorDAO;
	}

	//OPERACION LISTAR
	
	@RequestMapping("/list")
	public String listNadadors(Model model) {
		model.addAttribute("nadadors", nadadorDAO.getNadadores());
		return "nadador/list";
	}

	//OPERACION CREAR
	@RequestMapping(value="/add")
	public String addNadador(Model model) {
		model.addAttribute("nadador", new Nadador());
		return "nadador/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddSubmit(@ModelAttribute("nadador") Nadador nadador, BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "nadador/add";
		nadadorDAO.addNadador(nadador);
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/update/{nom}", method=RequestMethod.GET)
	public String editNadador(Model model, @PathVariable String nom){
		model.addAttribute("nadador", nadadorDAO.getNadador(nom));
		return "nadador/update";
	}
	
	@RequestMapping(value="/update/{nom}", method=RequestMethod.POST)
	public String processUpdateSubmit(@PathVariable String nom, @ModelAttribute("nadador") Nadador nadador, BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return "nadador/update";
		nadadorDAO.updateNadador(nadador);
		return "redirect:../list";
	}
	
		
	//OPERACION  BORRAR
	@RequestMapping(value="/delete/{nom}")
	public String processDelete(@PathVariable String nom) {
		nadadorDAO.deleteNadador(nom);
		return "redirect:../list";
	}

	
}
