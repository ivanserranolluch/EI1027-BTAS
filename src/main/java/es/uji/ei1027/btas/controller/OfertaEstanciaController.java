package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.btas.dao.OfertaEstanciaDAO;
import es.uji.ei1027.btas.model.OfertaEstancia;


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
	
	@RequestMapping(value="/update/{id_estancia}", method=RequestMethod.GET)
	public String editOfertaEstancia(Model model, @PathVariable int id_estancia){
		System.out.println("Hola");
			model.addAttribute("ofertasEstancias", ofertaEstanciaDao.getOfertaEstancia(id_estancia));
			System.out.println("Adios");
			return "ofertaEstancia/update";
	}
	
	
	@RequestMapping(value="/update/{id_estancia}", method=RequestMethod.POST)
	public String processUpdateSubmit2(@PathVariable int id_estancia, @ModelAttribute("ofertasEstancias") OfertaEstancia ofertaEstancia, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println("HolaError");
			System.out.println(bindingResult.hasErrors());
			return "vistaEmpresa";
		}
		System.out.println("Ento sii");
		ofertaEstanciaDao.updateOfertaEstanciaEmpresa(id_estancia, ofertaEstancia.getDescripcion());		
		return "vistaEmpresa";
	}
	
}
