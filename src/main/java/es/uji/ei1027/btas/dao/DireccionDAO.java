package es.uji.ei1027.btas.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.model.Direccion;
public class DireccionDAO {

	private JdbcTemplate jdbcTemplate;
	    
	@Autowired
	public void setDataSource(DataSource dataSource) { 
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class DireccionMapper implements RowMapper<Direccion> {  

	    public Direccion mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Direccion direccion = new Direccion();
	        direccion.setIdDir(rs.getInt("id_dir"));
	        direccion.setCalle(rs.getString("calle"));
	        direccion.setCiudad(rs.getString("ciudad"));
	        direccion.setCp(rs.getInt("cp"));
	        direccion.setNumero(rs.getInt("numero"));
	        
	        return direccion;
	    }
	}

	public List<Direccion> getDireccion() {  

		 return this.jdbcTemplate.query("select * from estudiante"
, new 	DireccionMapper());
	}	 
		
	public Direccion getEstudiante(int id_dir) {
		return this.jdbcTemplate.queryForObject("select * from estudiante where id_dir=?",  new Object[] {id_dir}, new DireccionMapper());
	}
	
	public void addDireccion(Direccion direccion) {
		this.jdbcTemplate.update(
				"insert into Direccion(id_dir, calle, cp, numero, ciudad) values(?, ?, ?, ?, ?)", direccion.getIdDir(), direccion.getCalle(), direccion.getCp(), direccion.getNumero(), direccion.getCiudad());
	}
	
	public void updateDireccion(Direccion direccion) {
		this.jdbcTemplate.update(
				"update Direccion set calle = ?, ciudad=?,cp=?,numero=? where id_dir = ?", direccion.getCalle(), direccion.getCiudad(), direccion.getCp(),direccion.getNumero(), direccion.getIdDir());
	}
		
	public void deleteEstudiante(int id_dir) {
		this.jdbcTemplate.update(
		        "delete from direccion where id_dir = ?",
		        id_dir);
	}

}


