package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.btas.model.Estudiante;


public class EstudianteDAO {
	
	private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) { 
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class EstudianteMapper implements RowMapper<Estudiante> {  

	    public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Estudiante estudiante = new Estudiante();
	        estudiante.setDni(rs.getString("dni"));
	        estudiante.setAl(rs.getString("al"));
	        estudiante.setNombre(rs.getString("nombre"));
	        estudiante.setApellidos(rs.getString("apellidos"));
	        estudiante.setTelefono(rs.getString("telefono"));
	        estudiante.setEmail(rs.getString("email"));
	        estudiante.setItinerario(rs.getString("itinerario"));
	        estudiante.setNotaMedia(rs.getDouble("notaMedia"));
	        estudiante.setNumAsigPendiente(rs.getInt("numAsigPend"));
	        estudiante.setNumCreditosAprobados(rs.getInt("creditosAprobados"));
	        estudiante.setSemestreInicioEstancia(rs.getInt("semestreInicioEstancia"));
	        
	        return estudiante;
	    }
	}

	public List<Estudiante> getEstudiantes() {  

		 return this.jdbcTemplate.query("select * from estudiante"
, new 	EstudianteMapper());
	}	 
		
	public Estudiante getEstudiante(String dni) {
		return this.jdbcTemplate.queryForObject("select * from estudiante where dni=?",  new Object[] {dni}, new EstudianteMapper());
	}
	
	public void addEstudiante(Estudiante estudiante) {
		this.jdbcTemplate.update(
				"insert into Estudiante(dni,al,nombre,apellidos,telefono,email,itinerario,notaMedia,numAsigPend,creditosAprobados,semestreInicioEstancia) values(?, ?, ?, ?)", estudiante.getDni(), estudiante.getAl(),estudiante.getNombre(),
				estudiante.getApellidos(), estudiante.getTelefono(),estudiante.getEmail(),estudiante.getItinerario(),estudiante.getNotaMedia(),estudiante.getNumAsigPendiente(),
				estudiante.getNumCreditosAprobados(),estudiante.getSemestreInicioEstancia());
	}
	//cambia el periodo delInicio de las practicas
	public void updateEstudiante(Estudiante estudiante) {
		this.jdbcTemplate.update(
				"update Estudiante set semestreInicioEstancia = ? where dni = ?", estudiante.getSemestreInicioEstancia(), estudiante.getDni());
	}
		
	public void deleteEstudiante(String dni) {
		this.jdbcTemplate.update(
		        "delete from estudiante where dni = ?",
		        dni);
	}

}
