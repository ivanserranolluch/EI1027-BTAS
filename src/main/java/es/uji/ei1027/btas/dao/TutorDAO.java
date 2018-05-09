package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.model.Tutor;

@Repository
public class TutorDAO implements TutorDAOInterface{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) { 
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	private static final class TutorMapper implements RowMapper<Tutor> {  

	    public Tutor mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Tutor tutor = new Tutor();
	        tutor.setDni(rs.getString("dni"));
	        tutor.setNombre(rs.getString("nombre"));
	        tutor.setEmail(rs.getString("email"));
	        tutor.setTelefono(rs.getInt("telefono"));
	        tutor.setDepartamento(rs.getString("departame"));
	        tutor.setDespacho(rs.getString("despacho"));
	        tutor.setDireccion(rs.getInt("id_dir"));
	        return tutor;
	    }
	}
	
	@Override
	public List<Tutor> getTutores() {
		return this.jdbcTemplate.query("select * from tutor join contacto using (dni)"
				, new 	TutorMapper());
	}

	@Override
	public Tutor getTutor(String dni) {
		return this.jdbcTemplate.queryForObject("select * from tutor join contacto using (dni) where dni=?",  new Object[] {dni}, new TutorMapper());

	}

	@Override
	public void addTutor(Tutor tutor) {
		this.jdbcTemplate.update(
				"insert into Contacto(dni,nombre,email,telefono,id_dir) values(?,?,?,?,?)",tutor.getDni(),tutor.getNombre(),tutor.getEmail(),tutor.getTelefono(), tutor.getDireccion())
;				
		this.jdbcTemplate.update("insert into Tutor(dni,departame,despacho,email) values(?,?,?,?)",
				tutor.getDni(), tutor.getDepartamento(),tutor.getDespacho(),tutor.getEmail());
	}		


	@Override
	public void updateTutor(String dni, int id_dir, String nombre, int telefono, String email, String departamento,
			String despacho) {
		this.jdbcTemplate.update(
				"update Contacto set email=?,telefono=?,nombre=?,id_dir=? where dni = ?", email,telefono,nombre, id_dir,dni);
		this.jdbcTemplate.update(
				"update Tutor set departame=?,despacho=?,email=? where dni = ?", departamento,despacho,email,dni);
		
	}

	@Override
	public void deleteTutor(String dni) {
		this.jdbcTemplate.update(
		        "delete from tutor where dni = ?",
		        dni);		
	}

}
