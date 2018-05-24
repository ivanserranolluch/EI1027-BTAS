package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.model.Notificacion;

@Repository
public class NotificacionDAO {

private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class NotificacionMapper implements RowMapper<Notificacion> { 

	    public Notificacion mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Notificacion notificacion = new Notificacion();
	        notificacion.setId(rs.getInt("id_oferta"));
	        notificacion.setDni(rs.getString("dni"));
	        notificacion.setMensaje(rs.getString("mensaje"));
	        notificacion.setFecha(rs.getDate("fecha"));
	        return notificacion;
	    }
	}
	public List<Notificacion> getNotificaciones() {
		return this.jdbcTemplate.query(
		     	"select id_oferta,dni,mensaje,fecha from notificacion;", 
		     	new NotificacionMapper());
	}


	public void addNotificacion(Notificacion notificacion) {
		this.jdbcTemplate.update(
				"insert into PreferenciasEstudiante(id_oferta,dni,mensaje,fecha) values(?,?, ?,)", notificacion.getId(),notificacion.getDni(),notificacion.getMensaje());
	}

//	public void deletePreferenciasEstudiante(int id,String dni) {
//		this.jdbcTemplate.update(
//		        "delete from preferenciasestudiante where id_oferta = ? and dni=?",
//		       id,dni);
//	}
	
}
