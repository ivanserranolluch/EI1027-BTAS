package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



import es.uji.ei1027.btas.model.PreferenciasEstudiante;
public class PreferenciasEstudianteDAO {
	
	private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class PreferenciasEstudianteMapper implements RowMapper<PreferenciasEstudiante> { 

	    public PreferenciasEstudiante mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        PreferenciasEstudiante preferenciasEstudiante = new PreferenciasEstudiante();
	        preferenciasEstudiante.setId(rs.getInt("id"));
	        preferenciasEstudiante.setOrden(rs.getInt("orden"));
	        preferenciasEstudiante.setEstado(rs.getString("estado"));
	        preferenciasEstudiante.setFechaUltimoCambio(rs.getDate("fechaUltimoCambio"));
	        return preferenciasEstudiante;
	    }
	}
	public List<PreferenciasEstudiante> getPreferencies() {
		return this.jdbcTemplate.query(
		     	"select id,id_ofertaProyecto,id_estudiante,orden,fechaUltimoCambio, estado from preferenciasEstudiante;", 
		     	new PreferenciasEstudianteMapper());
	}
	public List<PreferenciasEstudiante> getOfertaDePreferencies(String dni){
		return this.jdbcTemplate.query("SELECT * FROM preferenciasEstudiante WHERE dni=?;",
				new Object[] {dni}, new PreferenciasEstudianteMapper());
	}
	public void addPreferenciasEstudiante(PreferenciasEstudiante preferenciasEstudiante) {
		this.jdbcTemplate.update(
				"insert into PreferenciasEstudiante(id,id_oferta,id_estudiante,orden,estado,fechaUltimoCambio) values(?, ?, ?, ?,?,?)", preferenciasEstudiante.getId(),preferenciasEstudiante.getOfertaProyecto().getId(),preferenciasEstudiante.getEstudiante().getDni(),
				preferenciasEstudiante.getOrden(),preferenciasEstudiante.getEstado(),preferenciasEstudiante.getFechaUltimoCambio());
	}
	public void deletePreferenciasEstudiante(String id) {
		this.jdbcTemplate.update(
		        "delete from preferenciasEstudiante where id = ?",
		       id);
	}
	//cambia el orden de la preferencia
	public void updatePreferenciasEstudiante(PreferenciasEstudiante preferenciasEstudiante) {
		this.jdbcTemplate.update(
				"update PreferenciasEstudiante set orden = ? where id = ?", preferenciasEstudiante.getOrden(),preferenciasEstudiante.getId());
	}
			

}
