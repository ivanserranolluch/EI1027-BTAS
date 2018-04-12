package es.uji.ei1027.btas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.connection.ConnectionManager;
import es.uji.ei1027.btas.model.EstadoOferta;
import es.uji.ei1027.btas.model.Itinerario;
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
	        ofertaProyecto.setEstado(rs.getString("estado"));
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
	public OfertaProyecto getOfertaProyecto(int id) {
		return this.jdbcTemplate.queryForObject("select * from ofertaProyecto where id_oferta=?",  new Object[] {id}, new OfertaProyectoMapper());
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
		
	public void updateOfertaProyectoEstado(int id,String estado) {
		this.jdbcTemplate.update(
				"update OfertaProyecto set estado = ? where id_oferta=?", estado,id);
	}
		
	public void deleteOferta(int id) {
		this.jdbcTemplate.update(
		        "delete from ofertaProyecto where id_oferta = ?",
		        id);
	}
	
	public List<OfertaProyecto> getItinerario(Itinerario itinerario){
		return this.jdbcTemplate.query("SELECT * FROM OfertaProyecto WHERE itinerario=?;", new Object[] {itinerario.getDescripcion()}, new OfertaProyectoMapper());
	}
	/*
	private static int getNextId() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection(); 
			if (conn==null)
				Log.severe("JDBC no trobat");
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return -1;
		}
		List<Integer> listId = new ArrayList<Integer>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select pais,capital from pais");
			rs = stmt.executeQuery();
			while (rs.next()) {
				listId.add(rs.getInt("id_oferta"));
				
			}
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
			return -1;
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException e) {
					Log.warning("Error tancant ResultSet");
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexi� JDBC");				
				e.printStackTrace();
			}
		}
		return listId.get(-1)+1;

	}
*/
	@Override
	public void updateOfertaProyecto(int id, String estado, String itinerario, int id_estancia, Date fechaAlta,
			String objetivo, String tarea) {
		this.jdbcTemplate.update(
				"update OfertaProyecto set estado = ?,itinerario=?,id_estancia=?,fechaalta=?,tarea=?,objetivo=? where id_oferta=?", estado,itinerario,id_estancia,fechaAlta,tarea,objetivo,id);
		
	}}
