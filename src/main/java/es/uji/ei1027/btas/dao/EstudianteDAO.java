package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.model.Estudiante;
import es.uji.ei1027.btas.model.Itinerario;


@Repository
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
	        estudiante.setItinerario(rs.getString("itinerario"));
	        estudiante.setNotaMedia(rs.getDouble("notamedia"));
	        estudiante.setNumAsigPendiente(rs.getInt("numasigpen"));
	        estudiante.setNumCreditosAprobados(rs.getInt("numcreditosaprov"));
	        estudiante.setSemestreInicioEstancia(rs.getInt("semestreiniestancia"));
	        estudiante.setEmail(rs.getString("email"));
	        estudiante.setTelefono(rs.getInt("telefono"));
	        
	        
	        return estudiante;
	    }
	}

	public List<Estudiante> getEstudiantes() {  

		 return this.jdbcTemplate.query("select * from estudiante join contacto using (dni)"
, new 	EstudianteMapper());
	}	 
		
	public Estudiante getEstudiante(String dni) {
		return this.jdbcTemplate.queryForObject("select * from estudiante join contacto using (dni) where dni=?",  new Object[] {dni}, new EstudianteMapper());
	}
	
	public void addEstudiante(Estudiante estudiante) {
		
		this.jdbcTemplate.update(
				"insert into Contacto(dni,nombre,email,telefono,id_dir) values(?,?,?,?,2)",estudiante.getDni(),estudiante.getNombre(),estudiante.getEmail(),estudiante.getTelefono())
;				
		this.jdbcTemplate.update("insert into Estudiante(dni,al,apellidos,itinerario,notaMedia,numasigpen,numcreditosaprov,semestreiniestancia) values(?, ?,?,?,?,?,?,?)",
				estudiante.getDni(), estudiante.getAl(),
				estudiante.getApellidos(),
				estudiante.getItinerario().getDescripcion()
				,estudiante.getNotaMedia(),
				estudiante.getNumAsigPendiente(),
				estudiante.getNumCreditosAprobados(),estudiante.getSemestreInicioEstancia());
	}
	//cambia el periodo delInicio de las practicas
	public void updateEstudianteSemestreInicio(String dni,int semestreInicioEstancia) {
		this.jdbcTemplate.update(
				"update Estudiante set semestreiniestancia = ? where dni = ?", dni,semestreInicioEstancia);
	}
	
	public void updateEstudiante(String dni,String al,String nombre, String apellidos,
		 String itinerario, double notaMedia, int numAsigPendiente,int creditosAprobados,int semestreInicioEstancia,String email,int telefono) {
		this.jdbcTemplate.update(
				"update Contacto set email=?,telefono=?,nombre=? where dni = ?", email,telefono,nombre,dni);
		this.jdbcTemplate.update(
				"update Estudiante set al= ?,apellidos=?,itinerario=?,notaMedia=?,numasigpen = ?,"
				+ "numcreditosaprov=?,semestreIniEstancia = ? where dni = ?", al,apellidos,itinerario,notaMedia,
				numAsigPendiente,creditosAprobados,semestreInicioEstancia,dni);
	
	}
	
		
	public void deleteEstudiante(String dni) {
		this.jdbcTemplate.update(
		        "delete from estudiante where dni = ?",
		        dni);
	}
	
	public List<Estudiante> getItinerario(Itinerario itinerario){
		return this.jdbcTemplate.query("SELECT * FROM estudiante WHERE itinerario=?;", new Object[] {itinerario.getDescripcion()}, new EstudianteMapper());
	}

}
