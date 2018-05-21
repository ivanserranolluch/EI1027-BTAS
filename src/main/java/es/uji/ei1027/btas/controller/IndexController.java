package es.uji.ei1027.btas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")

public class IndexController {

	
	@RequestMapping("/index3")
	public String devuelveIndex() {
		
		return "index3";									
	}
}
