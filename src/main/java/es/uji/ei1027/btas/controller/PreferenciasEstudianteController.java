package es.uji.ei1027.btas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

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
import es.uji.ei1027.btas.dao.PreferenciasEstudianteDAO;
import es.uji.ei1027.btas.model.OfertaProyecto;
import es.uji.ei1027.btas.model.PreferenciasEstudiante;
import es.uji.ei1027.btas.services.NotificacionService;


@Controller
@RequestMapping("/preferenciasEstudiante")

public class PreferenciasEstudianteController {
	
private PreferenciasEstudianteDAO preferenciasEstudianteDao;
private  LinkedList<Integer> list = new LinkedList<Integer>();

	
	@Autowired
	public void set (PreferenciasEstudianteDAO preferenciasEstudianteDao){
		this.preferenciasEstudianteDao = preferenciasEstudianteDao;
	}
	

	/*@RequestMapping("/peritinerario")
	public String listPrefPorEstudiante(Model model){
		model.addAttribute("classificacions", estudianteService.getPreferenciasEstudiante("paco"));
		return "preferencies/perEstudiante";
	}*/
	
	//OPERACION LISTAR
	
			@RequestMapping("/list")
			public String listPreferencias(Model model) {
				
				model.addAttribute("preferencias", preferenciasEstudianteDao.getPreferencies());
			System.out.println("entro en la lista de preferencias de lledo");
				return "preferenciasEstudiante/list";
			}
			
			@RequestMapping(value="/listes/{dni}")
			public String listPreferenciasEstudiante(Model model, @PathVariable String dni) {
				System.out.println(dni+"4");
				
				model.addAttribute("preferencias", preferenciasEstudianteDao.getPreferenciaEstudiante(dni));
				System.out.println("entro en la lista de preferencias del estudiante");
				return "preferenciasEstudiante/listes";
			}
			
			
		
		
		
			/*@RequestMapping("/listitinerario")
			public String listOfertasItinerario(Model model) {
				model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
				return "ofertaProyecto/list";
			}*/

			//OPERACION CREAR
			@RequestMapping(value="/add/{id}/{dni}")
			public String addpreferenciaEstudiante(Model model,@PathVariable("id") int id,@PathVariable("dni") String dni) {
				System.out.println("creo una preferencia con"+"id"+id+"dni"+dni);
				model.addAttribute("preferenciasEstudiante", new PreferenciasEstudiante(id,dni));
				
				
				//session.setAttribute("id", id);
				//session.setAttribute("dni", dni);
				return "preferenciasEstudiante/add";
			}
			
			@RequestMapping(value="/add", method=RequestMethod.POST)
			public String processAddSubmit(@ModelAttribute("preferenciasEstudiante") PreferenciasEstudiante preferenciasEstudiante, BindingResult bindingResult){
				System.out.println("creo un dao para preferencia con");
				if (bindingResult.hasErrors()){
					System.out.println(bindingResult);
					return "preferenciasEstudiante/add";
					
				}
				System.out.println("orden"+preferenciasEstudiante.getOrden());
				
					preferenciasEstudianteDao.addPreferenciasEstudiante(preferenciasEstudiante);
				return "index3";
			}
			
			@RequestMapping(value="/update/{id}/{dni}", method=RequestMethod.GET)
			public String editOfertaProyecto(Model model, @PathVariable int id,@PathVariable String dni){
				System.out.println("entro en el get del update de preferendias con un id "+id+ "dni" +dni);
				
				model.addAttribute("preferenciasEstudiante", preferenciasEstudianteDao.getPreferencia(id,dni));
				return "preferenciasEstudiante/update";
			}
			
			@RequestMapping(value="/update", method=RequestMethod.POST)
			public String processUpdateSubmit(@ModelAttribute("preferenciasEstudiante") PreferenciasEstudiante preferenciasEstudiante, BindingResult bindingResult){
				//System.out.println("entro en el post del update de preferendias con un id "+id+ "dni" +dni);

				if(bindingResult.hasErrors()){
					System.out.println(bindingResult.hasErrors());
					return "preferenciasEstudiante/update";
				}
				
				System.out.println("id:"+preferenciasEstudiante.getId() + "dni"+preferenciasEstudiante.getDni());
				preferenciasEstudianteDao.updatePreferenciasEstudiante(preferenciasEstudiante.getId(),preferenciasEstudiante.getDni(),preferenciasEstudiante.getOrden(),preferenciasEstudiante.getDescEstado(),preferenciasEstudiante.getFechaUltimoCambio());
				
				return "index3";
			}
			
				
			//OPERACION  BORRAR
			@RequestMapping(value="/delete/{id}/{dni}")
			public String processDelete(@PathVariable int id,@PathVariable String dni) {
				preferenciasEstudianteDao.deletePreferenciasEstudiante(id,dni);;
				return "index3";
			}
			
			@InitBinder
			public void initBinder(final WebDataBinder binder){
			  final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD"); 
			  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
			}


}
