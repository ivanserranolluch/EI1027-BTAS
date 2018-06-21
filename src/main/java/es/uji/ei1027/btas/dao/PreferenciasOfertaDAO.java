package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.model.PreferenciaOferta;

@Repository
public class PreferenciasOfertaDAO {
	
private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class PreferenciasOfertaEstanciaMapper implements RowMapper<PreferenciaOferta> { 

	    public PreferenciaOferta mapRow(ResultSet rs, int rowNum) throws SQLException { 
	    	PreferenciaOferta preferenciasOferta = new PreferenciaOferta();
	    	preferenciasOferta.setId(rs.getInt("id_oferta"));
	    	preferenciasOferta.setOrden(rs.getInt("orden"));
	    	preferenciasOferta.setEstado(rs.getString("estado"));
	    	preferenciasOferta.setFechaUltimoCambio(rs.getDate("fechaultimocambio"));
	    	preferenciasOferta.setDni(rs.getString("dni"));
	    	preferenciasOferta.setItinerario(rs.getString("itinerario"));
	    	preferenciasOferta.setCif(rs.getString("cif"));
	    	preferenciasOferta.setTarea(rs.getString("tarea"));
	    	preferenciasOferta.setObjetivo(rs.getString("objetivo"));
	    	preferenciasOferta.setFechaAlta(rs.getDate("fechaalta"));
	    return preferenciasOferta;
	    }
	}
	
	public List<PreferenciaOferta> getPreferenciaOferta() {
		
		return this.jdbcTemplate.query(
		     	"select id_oferta,orden,o.estado,fechaultimocambio,p.dni,itinerario,fechaalta,objetivo,tarea,cif from preferenciasestudiante p join ofertaproyecto o using(id_oferta) order by orden;", 
		     	new PreferenciasOfertaEstanciaMapper());
	
}
}
