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
		public String listOfertaProyecto(Model model,@PathVariable("cif") String cif) {
			System.out.println("He entrado ofertasEstancias empresa");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertaCif(cif));
			System.out.println("entro en la lista de ofertas empresa");
			return "ofertaProyecto/listEmpresa";
			
		}
		@RequestMapping("/listEmpresaAnulacion/{cif}")
		public String listOfertaProyectoAnulacion(Model model,@PathVariable("cif") String cif) {
			System.out.println("He entrado ofertasEstancias empresa");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertaCif(cif));
			System.out.println("entro en la lista de ofertas empresa");
			return "ofertaProyecto/listEmpresaAnulacion";
			
		}
	
		@RequestMapping("/list")
		public String listOfertas(Model model) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
			return "ofertaProyecto/list";
		}
		
		@RequestMapping("/listes/{dni}")
		public String listOfertasEstudiant(Model model, @PathVariable("dni") String dni) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertasEstudiante(dni));
			return "ofertaProyecto/listes";
		}
		
		@RequestMapping("/listarCCT/{cif}")
		public String listOfertasCCT(Model model, @PathVariable("cif") String cif) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertasEmpresa(cif));
			return "ofertaProyecto/listarCCT";
		}
		
		@RequestMapping("/listBTC/{cif}")
		public String listOfertasBCT(Model model,@PathVariable("cif") String cif) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertasEmpresa(cif));
			return "ofertaProyecto/listBTC";
		}
		
		@RequestMapping("/listarOfertasTutor")
		public String listOfertasTutor(Model model) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertasTUTOR());
			return "ofertaProyecto/listarOfertasTutor";
		}
		@RequestMapping("/listarOfertasTutor2")
		public String listOfertasTutor2(Model model) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertasTUTOR());
			return "ofertaProyecto/listarOfertasTutor2";
		}
		
		@RequestMapping("/listarOfertasTutor/{cif}")
		public String listOfertasTutor(Model model,@PathVariable("cif") String cif) {
			System.out.println("entro aqui");
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertasEmpresa(cif));
			return "ofertaProyecto/listarOfertasTutor";
		}
		/*@RequestMapping("/listitinerario")
		public String listOfertasItinerario(Model model) {
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
			return "ofertaProyecto/list";
		}*/

		//OPERACION CREAR
		@RequestMapping(value="/addOfertaEmpresa", method=RequestMethod.GET)
		public String addOferta(Model model) { //,@PathVariable("id_estancia") int id_estancia 
			model.addAttribute("ofertas", new OfertaProyecto());
			System.out.println("he creado la estancia");
			return "ofertaProyecto/addOfertaEmpresa";
		}
				
		@RequestMapping(value="/addOfertaEmpresa/{cif}", method=RequestMethod.POST)
		public String processAddSubmit2(@PathVariable String cif,@ModelAttribute("ofertas") OfertaProyecto ofertaProyecto, BindingResult bindingResult){
			if (bindingResult.hasErrors()){
				System.out.println(bindingResult);
				return "ofertaEstancia/addOfertaEmpresa";
						
			}
			ofertaProyectoDAO.addOferta(ofertaProyecto,cif);
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
		
		@RequestMapping(value="/updateEstadoSolAnulado/{id}", method=RequestMethod.GET)
		public String editOfertaProyectoSolicitudAnulacion(Model model, @PathVariable int id){
			ofertaProyectoDAO.updateOfertaProyectoSolAnulacion(id);
			model.addAttribute("ofertas",ofertaProyectoDAO.getProyectoSolicitadoAnulacion(id));
			return "ofertaProyecto/updateEstadoSolAnulado";
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
		
		
		@RequestMapping(value="/updateBTC/{id}", method=RequestMethod.GET)
		public String editOfertaProyecto2(Model model, @PathVariable int id){
			System.out.println("algo ago");
			model.addAttribute("ofertaProyectos", ofertaProyectoDAO.getOfertaProyecto(id));
			System.out.println("y ago return");
			return "ofertaProyecto/updateBTC";
		}
		
		@RequestMapping(value="/updateBTC/{id}", method=RequestMethod.POST)
		public String processUpdateSubmit8(@PathVariable int id, @ModelAttribute("ofertaProyectos") OfertaProyecto ofertaProyecto, BindingResult bindingResult){
			System.out.println("Eiiii");
			if(bindingResult.hasErrors()){
				System.out.println(bindingResult.hasErrors());
				return "ofertaProyecto/updateBTC";
			}
			
			
			ofertaProyectoDAO.updateOfertaProyectoEstadoObjetivoTarea(id,ofertaProyecto.getDescEstado(), 
					ofertaProyecto.getObjetivo(),ofertaProyecto.getTarea());
			
			return "index2";
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
			String cif= ofertaProyecto.getCif();
			
			ofertaProyectoDAO.updateOfertaProyectoEstado(id,ofertaProyecto.getDescEstado());
			
			return "index4";
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
