package es.uji.ei1027.btas.services;

import java.util.List;

import es.uji.ei1027.btas.dao.AsignacionEmpresaTutorEstudianteDAO;
import es.uji.ei1027.btas.model.AsignacionEmpresaTutorEstudiante;
import org.springframework.beans.factory.annotation.Autowired;



public class AsignacionEmpresaTutorEstudianteSvc implements AsignacionEmpresaTutorEstudianteService{

	@Autowired
	AsignacionEmpresaTutorEstudianteDAO asignacionEmpresaTutorEstudianteDAO;
	@Override
	public List<AsignacionEmpresaTutorEstudiante> getAsignacionCompleta() {
		List<AsignacionEmpresaTutorEstudiante> asig= asignacionEmpresaTutorEstudianteDAO.getAsignacionCompleta();
		return asig;
	}

}
