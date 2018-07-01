package es.uji.ei1027.btas.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.uji.ei1027.btas.dao.UserDao;
import es.uji.ei1027.btas.model.UserDetails;

import org.springframework.validation.Errors; 
import org.springframework.validation.Validator;



class UserValidator implements Validator { 
	@Override
	public boolean supports(Class<?> cls) { 
		return UserDetails.class.isAssignableFrom(cls);
	}
	@Override 
	public void validate(Object obj, Errors errors) {
		UserDetails userDetails = (UserDetails)obj;
		if (userDetails.getUsername().trim().equals(""))
		    errors.rejectValue("nom", "obligatori", "Cal introduir un valor");
		if (userDetails.getPassword().trim().equals(""))
		       errors.rejectValue("contraseña", "obligatoria", "Cal introduir un valor");
	}
}

@Controller
public class LoginController {
	@Autowired
	private UserDao userDao;

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new UserDetails());
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String checkLogin(@ModelAttribute("user") UserDetails user, 		
				BindingResult bindingResult, HttpSession session) {
		UserValidator userValidator = new UserValidator(); 
		userValidator.validate(user, bindingResult); 
		if (bindingResult.hasErrors()) {
			return "login";
		}
	    // Comprueba que el login sea correcto 
		// intentant carregar les dades de l'usuari 
		user = userDao.loadUserByUsername(user.getUsername(),user.getPassword()); 
		if (user == null) {
			System.out.println("nulo");
			bindingResult.rejectValue("password", "badpw", "Contrasenya incorrecta"); 
			return "login";
		}
		// Autenticats correctament. 
		// Guardamos los datos del usuario autentificado en la sessión
		session.setAttribute("user", user); 
		
		// Torna a la pàgina principal
		if(user.getUsername() == "alice" || user.getUsername()=="btc") {
		return "index2";}
		
		if(user.getUsername() == "cct" || user.getUsername() == "ccd") {
			return "index4";
		}
		if(user.getUsername() == "A207327737" || user.getUsername() == "A11111111" || user.getUsername() == "A22222222" || user.getUsername() == "A33333333") {
			return "vistaEmpresa";
		}
		
		if(user.getUsername() == "5678" || user.getUsername() == "12345678T" || user.getUsername() == "12345676T" || user.getUsername() == "22345676T") {
			return "vistaTutor";
		}
		
		return "index3";
	}

	@RequestMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/";
	}
}
