package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.model.PreferenciaOfertaEstancia;

@Repository
public class PreferenciasOfertaEstanciaDAO {
	
private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class PreferenciasOfertaEstanciaMapper implements RowMapper<PreferenciaOfertaEstancia> { 

	    public PreferenciaOfertaEstancia mapRow(ResultSet rs, int rowNum) throws SQLException { 
	    	PreferenciaOfertaEstancia preferenciasOfertaEstancia = new PreferenciaOfertaEstancia();
	    	preferenciasOfertaEstancia.setId(rs.getInt("id_oferta"));
	    	preferenciasOfertaEstancia.setOrden(rs.getInt("orden"));
	    	preferenciasOfertaEstancia.setEstado(rs.getString("estado"));
	    	preferenciasOfertaEstancia.setFechaUltimoCambio(rs.getDate("fechaultimocambio"));
	    	preferenciasOfertaEstancia.setDni(rs.getString("dni"));
	    	preferenciasOfertaEstancia.setItinerario(rs.getString("itinerario"));
	    	preferenciasOfertaEstancia	.setId_estancia(rs.getInt("id_estancia"));
	    	preferenciasOfertaEstancia.setDescripcion(rs.getString("descripcion"));
	    	preferenciasOfertaEstancia.setSemestre(rs.getInt("semestre"));
	        return preferenciasOfertaEstancia;
	    }
	}
	
	public List<PreferenciaOfertaEstancia> getPreferenciaOfertaEstancia() {
		
		return this.jdbcTemplate.query(
		     	"select id_oferta,orden,o.estado,fechaultimocambio,p.dni,itinerario,id_estancia,descripcion,semestre from preferenciasestudiante p join ofertaproyecto o using(id_oferta) join estancia using(id_estancia);", 
		     	new PreferenciasOfertaEstanciaMapper());
	
}
}
