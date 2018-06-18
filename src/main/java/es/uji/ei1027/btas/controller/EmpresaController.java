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
import es.uji.ei1027.btas.dao.PersonaContactoDAO;
import es.uji.ei1027.btas.model.Empresa;

@Controller
@RequestMapping("/Empresa")
public class EmpresaController {
	private EmpresaDAO empresaDAO;
	private PersonaContactoDAO personaContactoDAO;
	
	@Autowired
	public void setEmpresaDAO (EmpresaDAO empresaDAO){
		this.empresaDAO = empresaDAO;
	}
	
	@Autowired
	public void setPersonaContactoDAO (PersonaContactoDAO personaContactoDAO){
		this.personaContactoDAO = personaContactoDAO;
	}
	
	//OPERACION LISTAR
		@RequestMapping("/list")
		public String listEmpresas(Model model) {
			model.addAttribute("empresas", empresaDAO.getEmpresas());
			return "Empresa/list";
		}
		
		@RequestMapping("/list2")
		public String listEmpresas2(Model model) {
			model.addAttribute("empresas", empresaDAO.getEmpresas());
			return "Empresa/list2";
		}
		
		@RequestMapping(value="/listEmpresa/{cif}", method=RequestMethod.GET)
		public String listEmpresa(Model model,@PathVariable String cif) {
			System.out.println("CIF"+cif);
			model.addAttribute("empresas", empresaDAO.getEmpresa(cif));
			model.addAttribute("personasContactos",personaContactoDAO.getPersonaContactos(cif));
			return "Empresa/listEmpresa";
		}
		
		@RequestMapping(value="/listEmpresa2/{cif}", method=RequestMethod.GET)
		public String listEmpresa2(Model model,@PathVariable String cif) {
			System.out.println("CIF"+cif);
			model.addAttribute("empresas", empresaDAO.getEmpresa(cif));
			model.addAttribute("personasContactos",personaContactoDAO.getPersonaContactos(cif));
			return "Empresa/listEmpresa2";
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
			
			return "redirect:../listEmpresa/"+cif;
		}
		@RequestMapping(value="/delete/{cif}")
		public String processDelete(@PathVariable String cif) {
			empresaDAO.deleteEmpresa(cif);
			return "redirect:../list";
		}
		
	
}
