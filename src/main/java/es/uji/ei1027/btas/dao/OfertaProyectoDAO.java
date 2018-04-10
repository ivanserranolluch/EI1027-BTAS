package es.uji.ei1027.btas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.connection.ConnectionManager;
import es.uji.ei1027.btas.model.EstadoOferta;
import es.uji.ei1027.btas.model.OfertaProyecto;

@Repository
public class OfertaProyectoDAO implements OfertaProyectoDAOInterface {
	
	private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class OfertaProyectoMapper implements RowMapper<OfertaProyecto> { 

	    public OfertaProyecto mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        OfertaProyecto ofertaProyecto = new OfertaProyecto();
	        ofertaProyecto.setId(rs.getInt("id_oferta"));
	        ofertaProyecto.setTarea(rs.getString("tarea"));
	        ofertaProyecto.setObjetivo(rs.getString("objetivo"));
	        //ofertaProyecto.setEstado(rs.getString("estado"));
	        ofertaProyecto.setItinerario(rs.getString("itinerario"));
	        ofertaProyecto.setFechaAlta(rs.getDate("fechaalta"));
	        ofertaProyecto.setIdEstancia(rs.getInt("id_estancia"));
	        return ofertaProyecto;
	    }
	}

	public List<OfertaProyecto> getOfertas() {
		
			return this.jdbcTemplate.query(
			     	"select * from ofertaProyecto", 
			     	new OfertaProyectoMapper());
		
	}
	public OfertaProyecto getOfertaProyecto(String id) {
		return this.jdbcTemplate.queryForObject("select * from ofertaProyecto where id=?",  new Object[] {id}, new OfertaProyectoMapper());
	}
	
/*	public void addOferta(OfertaProyecto ofertaProyecto) {
		this.jdbcTemplate.update(
				"insert into OfertaProyecto(id,tarea,objetivo,estado,itinerario,fechaDeAlta,fechaDeUltimoCambio) values(?, ?, ?, ?)", ofertaProyecto.getId(), ofertaProyecto.getTarea(),
				ofertaProyecto.getObjetivo(),ofertaProyecto.getEstado(), ofertaProyecto.getItinerario(),ofertaProyecto.getFechaDeAlta(),ofertaProyecto.getFechaUltimoCambio());
	}*/
		
	public void addOferta(OfertaProyecto ofertaProyecto) {
		this.jdbcTemplate.update(
				"insert into OfertaProyecto(id_oferta,fechaalta,itinerario,estado,objetivo,tarea,id_estancia) values(?, ?, ?, ?, ?, ?, ?)", ofertaProyecto.getId(), ofertaProyecto.getFechaAlta(),
				ofertaProyecto.getItinerario().getDescripcion(),ofertaProyecto.getEstado().getDescripcion(), ofertaProyecto.getObjetivo(),ofertaProyecto.getTarea(), ofertaProyecto.getIdEstancia());
	}
		
	public void updateOfertaProyecto(int id,EstadoOferta estado) {
		this.jdbcTemplate.update(
				"update OfertaProyecto set estado = ? where id=?", estado.getDescripcion(),id);
	}
		
	public void deleteOferta(int id) {
		this.jdbcTemplate.update(
		        "delete from ofertaProyecto where id = ?",
		        id);
	}
	
	public List<OfertaProyecto> getItinerario(String itinerario){
		return this.jdbcTemplate.query("SELECT * FROM OfertaProyecto WHERE itinerario=?;", new Object[] {itinerario}, new OfertaProyectoMapper());
	}
}
