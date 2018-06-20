package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.model.OfertaEstancia;

@Repository
public class OfertaEstanciaDAO {
private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	private static final class OfertaEstanciaMapper implements RowMapper<OfertaEstancia> { 

	    public OfertaEstancia mapRow(ResultSet rs, int rowNum) throws SQLException { 
	    	OfertaEstancia ofertaEstancia = new OfertaEstancia();
	   
	    	if(rs.getDate("fechaAlta")==null) {
	    		ofertaEstancia.setFechaAlta(new Date());
	    	}else{
	        	ofertaEstancia.setFechaAlta(rs.getDate("fechaAlta"));
	    	}
	    	if(rs.getString("estado")==null) {
	    		ofertaEstancia.setEstado("SinDefinir");
	    	}else {
	        	ofertaEstancia.setEstado(rs.getString("estado"));}
	    	
	    	if(rs.getString("objetivo")==null) {
	    		ofertaEstancia.setObjetivo("");
	    	}else {
	    		ofertaEstancia.setObjetivo(rs.getString("objetivo"));
	    		}
	    	
	     	if(rs.getString("tarea")==null) {
	    		ofertaEstancia.setTarea("");
	    	}else {
	    		ofertaEstancia.setTarea(rs.getString("tarea"));
	    		}
	   	ofertaEstancia.setCif(rs.getString("cif"));
	   	
    	   	ofertaEstancia.setId_estancia(rs.getInt("id_estancia"));
    	  
	 
	    	ofertaEstancia.setDescripcion(rs.getString("descripcion"));
	    	ofertaEstancia.setSemestre(rs.getInt("semestre"));
	     return ofertaEstancia;
	    }
	}
	
public List<OfertaEstancia> getOfertaEstancia(String cif) {
		
		return jdbcTemplate.query(
		     	"select fechaAlta,estado,objetivo,tarea,cif,id_estancia,descripcion,semestre from ofertaproyecto o  right outer join estancia using(id_estancia) where cif =?",
		     	new Object[] {cif}, new OfertaEstanciaMapper());
	
}

public OfertaEstancia getOfertaEstancia(int id_estancia) {
	return this.jdbcTemplate.queryForObject("select id_estancia,fechaAlta,estado,objetivo,tarea,cif,descripcion,semestre from ofertaProyecto right outer join estancia using (id_estancia) where id_estancia=?",  new Object[] {id_estancia}, new OfertaEstanciaMapper());
}
public void updateOfertaEstanciaEmpresa(int id_estancia,String descripcion) {
	this.jdbcTemplate.update(
			"update estancia set descripcion = ? where id_estancia=?", descripcion,id_estancia);
	
}

}
	

