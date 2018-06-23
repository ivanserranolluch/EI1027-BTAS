package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import es.uji.ei1027.btas.model.Asignacion;
import es.uji.ei1027.btas.model.Estudiante;
import es.uji.ei1027.btas.model.OfertaProyecto;

@Repository
public class AsignacionDAO{
private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	
	private static final class AsignacionMapper implements RowMapper<Asignacion> { 

	    public Asignacion mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Asignacion asignacion = new Asignacion();
	        
	        asignacion.setFechaAceptacion(rs.getDate("fechaAceptacion"));
	        
	        asignacion.setEstado(rs.getString("estadoAceptadaRechazada"));
	        asignacion.setDniE(rs.getString("dniE"));
	        asignacion.setDniT(rs.getString("dniT"));
	        asignacion.setId_oferta(rs.getInt("id_oferta"));
	        return asignacion;
	    }
	}
	
	public List<Asignacion> getAsignacion() {
		
		return this.jdbcTemplate.query(
		     	"select * from asignacion", 
		     	new AsignacionMapper());
	
}
	
	public List<Asignacion> getAsignacionEstudiante(String dniE) {
		return this.jdbcTemplate.query("select * from asignacion where dniE=?",  new Object[] {dniE}, new AsignacionMapper());
	}
	
	public void addAsignacion(Asignacion asignacion) {
		this.jdbcTemplate.update("insert into Asignacion(fechaAceptacion,estadoaceptadorechazado,dnie,dnit,id_oferta)values(?,'Aceptada',?,?,?);",
				asignacion.getFechaAceptacion(),asignacion.getDniE(),asignacion.getDniT(),asignacion.getId_oferta());

	}
	
	public List<Asignacion> getAsignacionesTutor(String dniT) {
		return this.jdbcTemplate.query("select * from asignacion where dniT=?",  new Object[] {dniT}, new AsignacionMapper());
	}
	
	//CREATES
	
public void addAsignacion(int id_oferta,String dniE, String dniT) {
		
	this.jdbcTemplate.update("insert into Asignacion(fechaAceptacion,estadoaceptadarechazada,dnie,dnit,id_oferta)values(?,'Aceptada',?,?,?);",
			new Date(),dniE,dniT,id_oferta);

}
	
	
}
