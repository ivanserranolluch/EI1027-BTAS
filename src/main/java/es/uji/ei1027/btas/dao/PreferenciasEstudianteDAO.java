
package es.uji.ei1027.btas.dao;


import java.sql.ResultSet;
import java.util.Date;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import es.uji.ei1027.btas.model.PreferenciasEstudiante;

@Repository
public class PreferenciasEstudianteDAO {
	
	private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class PreferenciasEstudianteMapper implements RowMapper<PreferenciasEstudiante> { 

	    public PreferenciasEstudiante mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        PreferenciasEstudiante preferenciasEstudiante = new PreferenciasEstudiante();
	        preferenciasEstudiante.setId(rs.getInt("id_oferta"));
	        preferenciasEstudiante.setOrden(rs.getInt("orden"));
	        preferenciasEstudiante.setEstado(rs.getString("estado"));
	        preferenciasEstudiante.setFechaUltimoCambio(rs.getDate("fechaultimocambio"));
	        preferenciasEstudiante.setDni(rs.getString("dni"));
	        return preferenciasEstudiante;
	    }
	}
	public List<PreferenciasEstudiante> getPreferencies() {
		return this.jdbcTemplate.query(
		     	"select id_oferta,orden,fechaultimocambio, estado,dni from preferenciasestudiante;", 
		     	new PreferenciasEstudianteMapper());
	}
//	public List<PreferenciasEstudiante> getPreferencies2() {
//		return this.jdbcTemplate.query(
//		     	"select id,id_ofertaProyecto,id_estudiante,orden,fechaUltimoCambio, estado from preferenciasEstudiante;", 
//		     	new PreferenciasEstudianteMapper());
//	}
	public List<PreferenciasEstudiante> getPreferenciaEstudiante(String dni){
		return this.jdbcTemplate.query("SELECT * FROM preferenciasEstudiante WHERE dni=? order by orden;",
				new Object[] {dni}, new PreferenciasEstudianteMapper());
	}
	public PreferenciasEstudiante getPreferencia(int id,String dni){
		return this.jdbcTemplate.queryForObject("select * from preferenciasEstudiante where id_oferta=? and dni =?",  new Object[] {id,dni}, new PreferenciasEstudianteMapper());
	}
	public void addPreferenciasEstudiante(PreferenciasEstudiante preferenciasEstudiante) {
		Date fechaHoy= new Date();
		this.jdbcTemplate.update(
				"insert into PreferenciasEstudiante(id_oferta,dni,orden,estado,fechaultimocambio) values(?,?, ?, ?, ?)", preferenciasEstudiante.getId(),preferenciasEstudiante.getDni(),
				preferenciasEstudiante.getOrden(),preferenciasEstudiante.getEstado().getDescripcion(),fechaHoy);
	}
//	public void addPreferenciasEstudiante(PreferenciasEstudiante preferenciasEstudiante) {
//		this.jdbcTemplate.update(
//				"insert into PreferenciasEstudiante(id,orden,estado,fechaultimocambio) values(?, ?, ?, ?,?,?)", preferenciasEstudiante.getId(),preferenciasEstudiante.getOfertaProyecto().getId(),preferenciasEstudiante.getEstudiante().getDni(),
//				preferenciasEstudiante.getOrden(),preferenciasEstudiante.getEstado(),preferenciasEstudiante.getFechaUltimoCambio());
//	}
	public void deletePreferenciasEstudiante(int id,String dni) {
		this.jdbcTemplate.update(
		        "delete from preferenciasestudiante where id_oferta = ? and dni=?",
		       id,dni);
	}
	//cambia el orden de la preferencia
//	public void updatePreferenciasEstudiante(PreferenciasEstudiante preferenciasEstudiante) {
//		this.jdbcTemplate.update(
//				"update PreferenciasEstudiante set orden = ? est where id = ?", preferenciasEstudiante.getOrden(),preferenciasEstudiante.getId());
//	}
	public void updatePreferenciasEstudiante(int id,String dni,int orden) {
		this.jdbcTemplate.update(
				"update PreferenciasEstudiante set orden = ?,  fechaultimocambio =? where id_oferta = ? and dni =?", orden,new Date(),id,dni);
	}		

}

