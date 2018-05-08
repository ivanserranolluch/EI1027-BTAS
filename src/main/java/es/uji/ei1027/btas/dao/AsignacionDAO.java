package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import es.uji.ei1027.btas.model.Asignacion;
import es.uji.ei1027.btas.model.EstadoAsignacion;
import org.springframework.jdbc.core.RowMapper;


public class AsignacionDAO  implements AsignacionDAOInterface{
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	private static final class AsignacionMapper implements RowMapper<Asignacion>{
		public Asignacion mapRow(ResultSet rs, int rowNum) throws SQLException{
			Asignacion asignacion = new Asignacion();
			asignacion.setFechaAceptacion(rs.getDate("fechaAsignacion"));
			asignacion.setFechaPropuesta(rs.getDate("fechaPropuesta"));
			asignacion.setEstadoAsignacion(rs.getString("estado"));
			asignacion.setFechaRechazo(rs.getDate("fechaRechazo"));
			asignacion.setFechaTraspaso(rs.getDate("fechaTraspaso"));
			asignacion.setComentarioPetCambio(rs.getString("comentarioPetCambio"));
			asignacion.setDniE(rs.getString("dniE"));
			asignacion.setDniT(rs.getString("dniT"));
			asignacion.setId_oferta(rs.getInt("id_oferta"));
			return asignacion;
			
		}


	}
	
	@Override
	public List<Asignacion> getAsignacion() {
		
		return this.jdbcTemplate.query("select * from asignacion", new AsignacionMapper());
		
	}

	@Override
	public Asignacion getAsignacionEstudiante(String dniE) {
		
		return this.jdbcTemplate.queryForObject("select * from asignacion where dniE=?", new Object[] {dniE}, new AsignacionMapper());
	}
	

	@Override
	public void addAsignacion(Asignacion asignacion) {
		
		
	}

	@Override
	public void updateAsignacionEstado(int id, String estado) {
		
		
	}

	@Override
	public void updateAsignacion() {
		
		
	}

	//Eliminar una Asignacion
	@Override
	public void deleteAsignacion(int id) {
		
	}

	//Lista de Asignaciones por EstadoAsignacion
	@Override
	public List<Asignacion> getEstado(EstadoAsignacion estadoAsignacion) {
		
		return this.jdbcTemplate.query("SELECT * FROM Asignacion WHERE estadoAsignacion=?;", new Object[] {estadoAsignacion.getDescripcion()}, new AsignacionMapper());
	}

}
