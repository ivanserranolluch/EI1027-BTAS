package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.btas.dao.OfertaEstanciaDAO;


@Controller
@RequestMapping("/ofertaEstancia")

public class OfertaEstanciaController {
	private OfertaEstanciaDAO ofertaEstanciaDao;
	
	@Autowired
	public void setOfertaEstanciaDAO (OfertaEstanciaDAO ofertaEstanciaDao){
		this.ofertaEstanciaDao = ofertaEstanciaDao;
	}
	
	@RequestMapping("/listarOfertaEstancia/{cif}")
	public String listOfertaEstancia(Model model,@PathVariable("cif") String cif) {
		System.out.println("He entrado ofertasEstancias empresa");
		model.addAttribute("ofertasEstancias", ofertaEstanciaDao.getOfertaEstancia(cif));
		System.out.println("entro en la lista de ofertas empresa");
		return "ofertaEstancia/listarOfertaEstancia";
		
	}
}
