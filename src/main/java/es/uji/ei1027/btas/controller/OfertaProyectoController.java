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

import es.uji.ei1027.btas.dao.NotificacionDAO;
import es.uji.ei1027.btas.dao.OfertaProyectoDAO;
import es.uji.ei1027.btas.model.Estancia;
import es.uji.ei1027.btas.model.OfertaProyecto;
import es.uji.ei1027.btas.services.NotificacionService;
import es.uji.ei1027.btas.services.NotificacionSvc;
import es.uji.ei1027.btas.services.OfertaProyectoService;
import es.uji.ei1027.btas.services.OfertaProyectoSvc;

@Controller
@RequestMapping("/ofertaProyecto")

public class OfertaProyectoController {
	
//private OfertaProyectoService ofertaProyectoService;

	private OfertaProyectoDAO ofertaProyectoDAO;
	private NotificacionDAO notificacionDao;
	private NotificacionService notificacion= new NotificacionSvc();
	
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
	
	
		@RequestMapping("/listEmpresa/{cif}")
		public String listOfertaEstancia(Model model,@PathVariable("cif") String cif) {
			System.out.println("He entrado ofertasEstancias empresa");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertaCif(cif));
			System.out.println("entro en la lista de ofertas empresa");
			return "ofertaProyecto/listEmpresa";
			
		}
	
		@RequestMapping("/list")
		public String listOfertas(Model model) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
			return "ofertaProyecto/list";
		}
		@RequestMapping("/listes")
		
		public String listOfertasEstudiant(Model model) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
			return "ofertaProyecto/listes";
		}
		
		@RequestMapping("/listarCCT")
		public String listOfertasCCT(Model model) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
			return "ofertaProyecto/listarCCT";
		}
		
		@RequestMapping("/listarOfertasTutor")
		public String listOfertasTutor(Model model) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
			return "ofertaProyecto/listarOfertasTutor";
		}
		/*@RequestMapping("/listitinerario")
		public String listOfertasItinerario(Model model) {
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
			return "ofertaProyecto/list";
		}*/

		//OPERACION CREAR
		@RequestMapping(value="/addOfertaEmpresa")
		public String addOferta(Model model) { //,@PathVariable("id_estancia") int id_estancia 
			model.addAttribute("ofertas", new OfertaProyecto());
			System.out.println("he creado la estancia");
			return "ofertaProyecto/addOfertaEmpresa";
		}
				
		@RequestMapping(value="/addOfertaEmpres", method=RequestMethod.POST)
		public String processAddSubmit2(@ModelAttribute("ofertas") OfertaProyecto ofertaProyecto, BindingResult bindingResult){
			if (bindingResult.hasErrors()){
				System.out.println(bindingResult);
				return "ofertaEstancia/addOfertaEmpresa";
						
			}
			ofertaProyectoDAO.addOferta(ofertaProyecto);
			return "vistaEmpresa";
		}
		
		
		
		@RequestMapping(value="/add/{id_estancia}")
		public String addOfertaProyecto(Model model,@PathVariable("id_estancia") int id) {
			System.out.println("entro en el add");
			model.addAttribute("ofertaProyecto", new OfertaProyecto(id));
			return "ofertaProyecto/add";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String processAddSubmit(@ModelAttribute("ofertaProyecto") OfertaProyecto ofertaProyecto,BindingResult bindingResult){
			if (bindingResult.hasErrors()){
				System.out.println(bindingResult);
				return "ofertaProyecto/add";
				
			}
				//notificacion.notificaEstudiantes(id);
				ofertaProyectoDAO.addOferta(ofertaProyecto);
			return "index2";
		}
		
		@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
		public String editOfertaProyecto(Model model, @PathVariable int id){
			
			model.addAttribute("ofertaProyecto", ofertaProyectoDAO.getOfertaProyecto(id));
			return "ofertaProyecto/update";
		}
		
		@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
		public String processUpdateSubmit(@PathVariable int id, @ModelAttribute("ofertaProyecto") OfertaProyecto ofertaProyecto, BindingResult bindingResult){
			
			if(bindingResult.hasErrors()){
				System.out.println(bindingResult.hasErrors());
				return "ofertaProyecto/update";
			}
			
			
			ofertaProyectoDAO.updateOfertaProyecto(id,ofertaProyecto.getDescEstado(), ofertaProyecto.getDescItinerario(), 
					ofertaProyecto.getFechaAlta(),ofertaProyecto.getObjetivo(),ofertaProyecto.getTarea());
			
			return "redirect:../list";
		}
		
		
		@RequestMapping(value="/updateEstado/{id}", method=RequestMethod.GET)
		public String editOfertaProyectoEstado(Model model, @PathVariable int id){
			
			model.addAttribute("ofertaProyecto", ofertaProyectoDAO.getOfertaProyecto(id));
			return "ofertaProyecto/updateEstado";
		}
		
		@RequestMapping(value="/updateEstado/{id}", method=RequestMethod.POST)
		public String processUpdateSubmitEstado(@PathVariable int id, @ModelAttribute("ofertaProyecto") OfertaProyecto ofertaProyecto, BindingResult bindingResult){
			
			if(bindingResult.hasErrors()){
				System.out.println(bindingResult.hasErrors());
				return "ofertaProyecto/updateEstado";
			}
			
			
			ofertaProyectoDAO.updateOfertaProyectoEstado(id,ofertaProyecto.getDescEstado());
			
			return "redirect:../listarCCT";
		}
			
		
		@RequestMapping(value="/updateEstadoBTC/{id}", method=RequestMethod.GET)
		public String editOfertaProyectoEstadoBTC(Model model, @PathVariable int id){
			
			model.addAttribute("ofertaProyecto", ofertaProyectoDAO.getOfertaProyecto(id));
			return "ofertaProyecto/updateEstadoBTC";
		}
		
		@RequestMapping(value="/updateEstadoBTC/{id}", method=RequestMethod.POST)
		public String processUpdateSubmitEstadoBTC(@PathVariable int id, @ModelAttribute("ofertaProyecto") OfertaProyecto ofertaProyecto, BindingResult bindingResult){
			
			if(bindingResult.hasErrors()){
				System.out.println(bindingResult.hasErrors());
				return "ofertaProyecto/updateEstadoBTC";
			}
			
			
			ofertaProyectoDAO.updateOfertaProyectoEstado(id,ofertaProyecto.getDescEstado());
			
			return "redirect:../list";
		}
		
		
		@RequestMapping(value="/updateEstadoEmpresa/{id}", method=RequestMethod.GET)
		public String editOfertaProyectoEmpresa(Model model, @PathVariable int id){
			
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertaProyecto(id));
			return "ofertaProyecto/updateEstadoEmpresa";
		}
		
		@RequestMapping(value="/updateEstadoEmpresa/{id}", method=RequestMethod.POST)
		public String processUpdateSubmitEmpresa(@PathVariable int id, @ModelAttribute("ofertas") OfertaProyecto ofertaProyecto, BindingResult bindingResult){
			
			if(bindingResult.hasErrors()){
				System.out.println(bindingResult.hasErrors());
				return "ofertaProyecto/updateEstadoEmpresa";
			}
			
			
			ofertaProyectoDAO.updateOfertaProyectoEstadoObjetivoTarea(id,ofertaProyecto.getDescEstado(),ofertaProyecto.getTarea(),ofertaProyecto.getObjetivo());
			
			return "vistaEmpresa";
		}
		//OPERACION  BORRAR
		@RequestMapping(value="/delete/{id}")
		public String processDelete(@PathVariable int id) {
			ofertaProyectoDAO.deleteOferta(id);
			return "redirect:../list";
		}
		
		@InitBinder
		public void initBinder(final WebDataBinder binder){
		  final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD"); 
		  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		}

	

}
