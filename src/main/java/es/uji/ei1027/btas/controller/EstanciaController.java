package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.btas.dao.EstanciaDAO;

import es.uji.ei1027.btas.model.Estancia;



@Controller
@RequestMapping("/estancia")
public class EstanciaController {

	private EstanciaDAO estanciaDAO;
	
	@Autowired
	public void setEstanciaDAO (EstanciaDAO estanciaDAO){
		this.estanciaDAO = estanciaDAO;
	}
	
	
	//OPERACION LISTAR
	@RequestMapping("/list")
	public String listEstancias(Model model) {
		model.addAttribute("estancias", estanciaDAO.getEstancias());
		return "estancia/list";
	}
	
	@RequestMapping("/listarOfertasPropias/{cif}")
	public String listEstancias2(Model model, @PathVariable("cif") String cif) {
		model.addAttribute("estancias", estanciaDAO.getEstanciasPropias(cif));
		return "estancia/listarOfertasPropias";
	}
	
	//OPERACION CREAR
	@RequestMapping(value="/add")
	public String addEstancia(Model model) { //,@PathVariable("id_estancia") int id_estancia 
		model.addAttribute("estanciaAdd", new Estancia());
		System.out.println("he creado la estancia");
		return "estancia/add";
	}
			
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddSubmit(@ModelAttribute("estanciaAdd") Estancia estancia, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			System.out.println(bindingResult);
			return "estancia/add";
					
		}
		estanciaDAO.addEstancia(estancia);
		return "vistaEmpresa";
	}
	
	//MODIFICAR ESTANCIA
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String editEstancia(Model model, @PathVariable int id){
			model.addAttribute("estanciaEdit", estanciaDAO.getEstancia(id));
			return "estancia/update";
	}
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String processUpdateSubmit(@PathVariable int id, @ModelAttribute("estanciaEdit") Estancia estancia, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.hasErrors());
			return "estancia/update";
		}
		System.out.println("");
		estanciaDAO.updateEstancia(id, estancia.getDescripcion(), estancia.getDni(), estancia.getCif());		
		return "vistaEmpresa";
	}
	
	//BORRAR ESTANCIA
	@RequestMapping(value="/delete/{id_estancia}")
	public String processDelete(@PathVariable int id_estancia) {
		estanciaDAO.deleteEstancia(id_estancia);
		return "redirect:../list";
	}
	
}
