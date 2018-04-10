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

import es.uji.ei1027.btas.dao.OfertaProyectoDAO;
import es.uji.ei1027.btas.model.OfertaProyecto;
import es.uji.ei1027.btas.services.OfertaProyectoService;
import es.uji.ei1027.btas.services.OfertaProyectoSvc;

@Controller
@RequestMapping("/ofertaProyecto")

public class OfertaProyectoController {
	
//private OfertaProyectoService ofertaProyectoService;

	private OfertaProyectoDAO ofertaProyectoDAO;
	
	/*@Autowired
	public void set (OfertaProyectoService ofertaProyectoService){
		this.ofertaProyectoService = ofertaProyectoService;
	}*/
	@Autowired
	public void setOfertaProyectoDAO (OfertaProyectoDAO ofertaProyectoDAO){
		this.ofertaProyectoDAO = ofertaProyectoDAO;
	}

	/*@RequestMapping("/peritinerario")
	public String listOfertaPerItinerari(Model model){
		model.addAttribute("classificacions", ofertaProyectoService.getOfertasItinerario("INGENIERA_SOFTWARE"));
		return "ofertaProyecto/perItinerari";
	}*/
	
	//OPERACION LISTAR
	
		@RequestMapping("/list")
		public String listOfertas(Model model) {
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
			return "ofertaProyecto/list";
		}

		//OPERACION CREAR
		@RequestMapping(value="/add")
		public String addOfertaProyecto(Model model) {
			model.addAttribute("ofertaProyecto", new OfertaProyecto());
			return "ofertaProyecto/add";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String processAddSubmit(@ModelAttribute("ofertaProyecto") OfertaProyecto ofertaProyecto, BindingResult bindingResult){
			if (bindingResult.hasErrors()){
				System.out.println(bindingResult);
				return "ofertaProyecto/add";
				
			}
				ofertaProyectoDAO.addOferta(ofertaProyecto);
			return "redirect:list.html";
		}
		
		@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
		public String editOfertaProyecto(Model model, @PathVariable String id){
			model.addAttribute("ofertaProyecto", ofertaProyectoDAO.getOfertaProyecto(id));
			return "ofertaProyecto/update";
		}
		
		@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
		public String processUpdateSubmit(@PathVariable int id, @ModelAttribute("ofertaProyecto") OfertaProyecto ofertaProyecto, BindingResult bindingResult){
			if(bindingResult.hasErrors())
				return "ofertaProyecto/update";
			ofertaProyectoDAO.updateOfertaProyecto(id,ofertaProyecto.getEstado());
			return "redirect:../list";
		}
		
			
		//OPERACION  BORRAR
		@RequestMapping(value="/delete/{id}")
		public String processDelete(@PathVariable int id) {
			ofertaProyectoDAO.deleteOferta(id);
			return "redirect:../list";
		}
		
		@InitBinder
		public void initBinder(final WebDataBinder binder){
		  final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
		  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		}

	

}
