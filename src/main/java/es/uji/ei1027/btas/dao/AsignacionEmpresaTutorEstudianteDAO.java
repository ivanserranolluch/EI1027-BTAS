package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.btas.model.AsignacionEmpresaTutorEstudiante;

public class AsignacionEmpresaTutorEstudianteDAO {

	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	private static final class AsignacionEmpresaTutorEstudianteMapper implements RowMapper<AsignacionEmpresaTutorEstudiante> { 

	    public AsignacionEmpresaTutorEstudiante mapRow(ResultSet rs, int rowNum) throws SQLException { 
	    	AsignacionEmpresaTutorEstudiante asignacionEmpresaTutorEstudiante = new AsignacionEmpresaTutorEstudiante();
	    	asignacionEmpresaTutorEstudiante.setId_oferta(rs.getInt("id_oferta"));
	    	asignacionEmpresaTutorEstudiante.setEstadoAceptadaRechazada(rs.getString("estadoaceptadarechazada"));
	    	asignacionEmpresaTutorEstudiante.setFechaAceptacion(rs.getDate("fechaAceptacion"));
	    	asignacionEmpresaTutorEstudiante.setDniE(rs.getString("dniE"));
	    	asignacionEmpresaTutorEstudiante.setDniT(rs.getString("dniT"));
	    	asignacionEmpresaTutorEstudiante.setCif(rs.getString("cif"));
	    	asignacionEmpresaTutorEstudiante.setNombreEstudiante(rs.getString("nombreEstudiante"));
	    	asignacionEmpresaTutorEstudiante.setNombreTutor(rs.getString("nombreTutor"));
	    	asignacionEmpresaTutorEstudiante.setNombreEmpresa(rs.getString("nombreEmpresa"));
	    return asignacionEmpresaTutorEstudiante;
	    }
	}
	
	public List<AsignacionEmpresaTutorEstudiante> getAsignacionCompleta() {
		
		return this.jdbcTemplate.query(
		     	"Select o.id_oferta,fechaAceptacion, e.nombre as nombreEstudiante, a.dniE as dniE, t.nombre as nombreTutor,a.dniT as dniT,em.nombre as nombreEmpresa,o.cif as cif,estadoaceptadarechazada from contacto e join asignacion a on e.dni=a.dniE join contacto t on a.dniT=t.dni join ofertaProyecto o on o.id_oferta=a.id_oferta join empresa em on em.cif=o.cif" 
		     	 ,new AsignacionEmpresaTutorEstudianteMapper());
	}
	
	
}
