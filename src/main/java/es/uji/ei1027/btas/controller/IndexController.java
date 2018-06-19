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
	@RequestMapping("/index2")
	public String devuelveIndex2() {
		
		return "index2";									
	}
	
	@RequestMapping("/index4")
	public String devuelveIndex4() {
		
		return "index4";									
	}
	
	@RequestMapping("/btc")
	public String devuelvebtc() {
		
		return "btc";									
	}
}
