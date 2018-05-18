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
import es.uji.ei1027.btas.dao.PreferenciasEstudianteDAO;
import es.uji.ei1027.btas.model.OfertaProyecto;
import es.uji.ei1027.btas.model.PreferenciasEstudiante;
import es.uji.ei1027.btas.services.PreferenciasEstudianteService;


@Controller
@RequestMapping("/preferenciasEstudiante")
public class PreferenciasEstudianteController {
	
private PreferenciasEstudianteDAO preferenciasEstudianteDao;

	
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
			System.out.println("haseqwuiiiiii");
				return "preferenciasEstudiante/list";
			}
			
			@RequestMapping(value="/listes/{dni}")
			public String listPreferenciasEstudiante(Model model, @PathVariable String dni) {
				System.out.println(dni+"4");
				
				model.addAttribute("preferencias", preferenciasEstudianteDao.getPreferenciaEstudiante(dni));
				System.out.println("hastaWWWWWWW aquiiiiii2");
				return "preferenciasEstudiante/listes";
			}
			
			
		
		
		
			/*@RequestMapping("/listitinerario")
			public String listOfertasItinerario(Model model) {
				model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
				return "ofertaProyecto/list";
			}*/

			//OPERACION CREAR
			@RequestMapping(value="/add/{id}{dni}")
			public String addpreferenciaEstudiante(Model model,@PathVariable String dni,@PathVariable int id) {
				model.addAttribute("preferenciasEstudiante", new PreferenciasEstudiante());
				return "preferenciasEstudiante/add";
			}
			
			@RequestMapping(value="/add/{id}{dni}", method=RequestMethod.POST)
			public String processAddSubmit(@ModelAttribute("preferenciasEstudiante") PreferenciasEstudiante preferenciasEstudiante,@PathVariable String dni,@PathVariable int id, BindingResult bindingResult){
				if (bindingResult.hasErrors()){
					System.out.println(bindingResult);
					return "preferenciasEstudiante/add";
					
				}
					preferenciasEstudianteDao.addPreferenciasEstudiante(preferenciasEstudiante,id,dni);
				return "redirect:listes.html";
			}
			
			@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
			public String editOfertaProyecto(Model model, @PathVariable int id){
				
				model.addAttribute("preferenciasEstudiante", preferenciasEstudianteDao.getPreferencia(id));
				return "preferenciasEstudiante/update";
			}
			
			@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
			public String processUpdateSubmit(@PathVariable int id, @ModelAttribute("preferenciasEstudiante") PreferenciasEstudiante preferenciasEstudiante, BindingResult bindingResult){
				
				if(bindingResult.hasErrors()){
					System.out.println(bindingResult.hasErrors());
					return "preferenciasEstudiante/update";
				}
				
		
				preferenciasEstudianteDao.updatePreferenciasEstudiante(id,preferenciasEstudiante.getOrden(),preferenciasEstudiante.getDescEstado(),preferenciasEstudiante.getFechaUltimoCambio());;
				
				return "redirect:../list";
			}
			
				
			//OPERACION  BORRAR
			@RequestMapping(value="/delete/{id}")
			public String processDelete(@PathVariable int id) {
				preferenciasEstudianteDao.deletePreferenciasEstudiante(id);;
				return "redirect:../list";
			}
			
			@InitBinder
			public void initBinder(final WebDataBinder binder){
			  final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD"); 
			  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
			}


}
