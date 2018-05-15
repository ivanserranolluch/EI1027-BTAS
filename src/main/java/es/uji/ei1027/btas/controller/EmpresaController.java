package es.uji.ei1027.btas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.btas.dao.EmpresaDAO;
import es.uji.ei1027.btas.dao.TutorDAO;
import es.uji.ei1027.btas.model.Empresa;
import es.uji.ei1027.btas.model.Tutor;

@Controller
@RequestMapping("/Empresa")
public class EmpresaController {
	private EmpresaDAO empresaDAO;
	
	@Autowired
	public void setEmpresaDAO (EmpresaDAO empresaDAO){
		this.empresaDAO = empresaDAO;
	}
	
	//OPERACION LISTAR
		@RequestMapping("/list")
		public String listEmpresas(Model model) {
			model.addAttribute("empresas", empresaDAO.getEmpresas());
			return "Empresa/list";
		}
		
		@RequestMapping(value="/listEmpresa/{cif}", method=RequestMethod.GET)
		public String listEmpresa(Model model,@PathVariable String cif) {
			model.addAttribute("empresas", empresaDAO.getEmpresa(cif));
			//model.addAttribute("personaContactos",personaContactoDAO.getPersonas());
			return "Empresa/listEmpresa";
		}
		
		//OPERACION CREAR
		
		@RequestMapping(value="/add")
		public String addEmpresa(Model model) {
			model.addAttribute("empresa", new Empresa());
			return "Empresa/add";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String processAddSubmit(@ModelAttribute("empresa") Empresa empresa, BindingResult bindingResult){
			if (bindingResult.hasErrors()){
				System.out.println(bindingResult);
				return "Empresa/add";
				
			}
			empresaDAO.addEmpresa(empresa);
			return "redirect:list.html";
		}
		
		@RequestMapping(value="/update/{cif}", method=RequestMethod.GET)
		public String editTutor(Model model, @PathVariable String cif){
			
			model.addAttribute("empresa", empresaDAO.getEmpresa(cif));
			return "Empresa/update";
		}
		
		@RequestMapping(value="/update/{cif}", method=RequestMethod.POST)
		public String processUpdateSubmit(@PathVariable String cif, @ModelAttribute("empresa") Empresa empresa, BindingResult bindingResult){
			if(bindingResult.hasErrors()){
				System.out.println(bindingResult.hasErrors());
				return "Empresa/update";
			}
			
			empresaDAO.updateEmpresa(cif,empresa.getDireccion(),empresa.getNombre(),empresa.getTelefono(),empresa.getEmail(),empresa.getDireccionWeb());
			
			return "redirect:../list";
		}
		@RequestMapping(value="/delete/{cif}")
		public String processDelete(@PathVariable String cif) {
			empresaDAO.deleteEmpresa(cif);
			return "redirect:../list";
		}
		
		@RequestMapping(value="../indexaciones/index2")
		public String processAtras() {
			return "redirect:../indexaciones/index2";
		}
}
