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

import es.uji.ei1027.btas.dao.InternetAddress;
import es.uji.ei1027.btas.dao.MessagingException;
import es.uji.ei1027.btas.dao.MimeMessage;
import es.uji.ei1027.btas.dao.OfertaProyectoDAO;
import es.uji.ei1027.btas.dao.Properties;
import es.uji.ei1027.btas.dao.Session;
import es.uji.ei1027.btas.dao.String;
import es.uji.ei1027.btas.dao.Transport;
import es.uji.ei1027.btas.model.OfertaProyecto;
import es.uji.ei1027.btas.services.OfertaProyectoService;
import es.uji.ei1027.btas.services.OfertaProyectoSvc;

@Controller
@RequestMapping("/ofertaProyecto")

public class OfertaProyectoController {
	
	private final Properties properties = new Properties();
	private Session session;
	private String password = "betasuji1";
	private void init() {
		 
		properties.put("mail.smtp.host", "mail.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port",25);
		properties.put("mail.smtp.mail.sender","betasuji@gmail.com");
		properties.put("mail.smtp.user", "betasuji@gmail.com");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
	}
	
	
	public void sendEmailConCorreo(String[] destinatarios){
		 
		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			
			//Con esto enviamos a varios usuarios
			Address []destinos = new Address[destinatarios.length];//Aqui usamos el arreglo de destinatarios
            for(int i=0;i<destinos.length;i++){
                destinos[i]=new InternetAddress(destinatarios[i]);
            }
            
			message.addRecipient(Message.RecipientType.TO, destinos);
			message.setSubject("Prueba");
			message.setText("Texto");
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
                        //Aqui se deberia o mostrar un mensaje de error o en lugar
                        //de no hacer nada con la excepcion, lanzarla para que el modulo
                        //superior la capture y avise al usuario con un popup, por ejemplo.
			return;
		}
		
	}
	
	
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
			
			//Envio los correos a todos los estudiantes
			System.out.println("Envio los correos ");
			sendEmailConCorreo(listarCorreosEstudiantes());
			
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
		/*@RequestMapping("/listitinerario")
		public String listOfertasItinerario(Model model) {
			model.addAttribute("ofertas", ofertaProyectoDAO.getOfertas());
			return "ofertaProyecto/list";
		}*/

		//OPERACION CREAR
		@RequestMapping(value="/add")
		public String addOfertaProyecto(Model model) {
			System.out.println("enqweqwtro aqui");
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
					ofertaProyecto.getIdEstancia(),ofertaProyecto.getFechaAlta(),ofertaProyecto.getObjetivo(),ofertaProyecto.getTarea());
			
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
		  final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD"); 
		  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		}

	

}
