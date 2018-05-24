package es.uji.ei1027.btas.controller;

import java.text.SimpleDateFormat;

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
import es.uji.ei1027.btas.model.Notificacion;


@Controller
@RequestMapping("/notificacion")
public class NotificacionController {
	
private NotificacionDAO notificacionDao;

	
	@Autowired
	public void set (NotificacionDAO notificacionDao){
		this.notificacionDao = notificacionDao;
	}
	

	
	//OPERACION LISTAR
	
			@RequestMapping("/list")
			public String listPreferencias(Model model) {
				
				model.addAttribute("notificaciones", notificacionDao.getNotificaciones());
				return "notificacion/list";
			}
			
		

			//OPERACION CREAR
			@RequestMapping(value="/add/{id}/{dni}")
			public String addpreferenciaEstudiante(Model model,@PathVariable("id") int id,@PathVariable("dni") String dni) {
				System.out.println("creo una notificacion con"+"id"+id+"dni"+dni);
				model.addAttribute("notificacion", new Notificacion(id,dni));
				
				return "notificacion/add";
			}
			
			@RequestMapping(value="/add", method=RequestMethod.POST)
			public String processAddSubmit(@ModelAttribute("notificacion") Notificacion notificacion, BindingResult bindingResult){
				System.out.println("creo un dao para preferencia con");
				if (bindingResult.hasErrors()){
					System.out.println(bindingResult);
					return "notificacion/add";
					
				}
				
				notificacionDao.addNotificacion(notificacion);;
				return "index2";
			}
			
			
			
				
//			//OPERACION  BORRAR
//			@RequestMapping(value="/delete/{id}/{dni}")
//			public String processDelete(@PathVariable int id,@PathVariable String dni) {
//				preferenciasEstudianteDao.deletePreferenciasEstudiante(id,dni);;
//				return "index3";
//			}
//			
//			@InitBinder
//			public void initBinder(final WebDataBinder binder){
//			  final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD"); 
//			  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//			}



}
