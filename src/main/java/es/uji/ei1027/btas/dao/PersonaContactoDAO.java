package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import es.uji.ei1027.btas.model.PersonaContacto;

@Repository
public class PersonaContactoDAO implements PersonaContactoDAOInterface{
	
private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class PersonaContactoMapper implements RowMapper<PersonaContacto> { 

	    public PersonaContacto mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        PersonaContacto personaContacto = new PersonaContacto();
	        personaContacto.setDni(rs.getString("dni"));
	        personaContacto.setCif(rs.getString("cif"));
	        return personaContacto;
	    }
	}
	
	
	//LISTAR PERSONAS CONTACTO
	@Override
	public List<PersonaContacto> getPersonaContactos() {
		return jdbcTemplate.query("select * from personacontacto", new PersonaContactoMapper());
	}
	
	public PersonaContacto getPersonaContacto(String dni) {
		return jdbcTemplate.queryForObject("select * from personacontacto where dni=?",new Object[] {dni}, new PersonaContactoMapper());
	}


	@Override
	public void addPersonaContacto(PersonaContacto personaContacto) {
		this.jdbcTemplate.update(
				"insert into personacontacto(dni,cif) values(?, ?)", personaContacto.getDni(),personaContacto.getCif());
		
	}

	@Override
	public void updatePersonaContacto(String dni, String cif) {
		this.jdbcTemplate.update("update personacontacto set cif = ? where dni=?", cif,dni);
	}

	@Override
	public void deletePersonaContacto(String dni) {
		this.jdbcTemplate.update("delete from personacontacto where dni = ?",dni);
	}

}
