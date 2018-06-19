package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import es.uji.ei1027.btas.model.Estancia;




@Repository
public class EstanciaDAO implements EstanciaDAOInterface{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class EstanciaMapper implements RowMapper<Estancia> { 

	    public Estancia mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Estancia estancia = new Estancia(); 
	        estancia.setId_estancia(rs.getInt("id_estancia"));
	        estancia.setDescripcion(rs.getString("descripcion"));
	        estancia.setDni(rs.getString("dni"));
	        estancia.setCif(rs.getString("cif"));
	        estancia.setSemestre(rs.getInt("semestre"));
	        return estancia;
	    }
	}
	
	//LISTAR LA LISTA DE ESTANCIAS
	@Override
	public List<Estancia> getEstancias() {
		return jdbcTemplate.query("select * from estancia", new EstanciaMapper());
	}
	
	
	public Estancia getEstancia(int id_estancia) {
		return this.jdbcTemplate.queryForObject("select * from estancia where id_estancia=?",  new Object[] {id_estancia}, new EstanciaMapper());
	}

	
	//AÑADIR NUEVA ESTANCIA
	@Override
	public void addEstancia(Estancia estancia) {
		this.jdbcTemplate.update(
				"insert into estancia(descripcion,dni,cif) values(?, ?, ?)",estancia.getDescripcion(),estancia.getDni(),estancia.getCif());
		
	}
	
	//BORRAR ESTANCIA
	public void deleteEstancia(int id_estancia) {
		this.jdbcTemplate.update(
		        "delete from estancia where id_estancia = ?",
		        id_estancia);
	}
	
	
	//MODIFICAR ESTANCIA
	public void updateEstancia(int id_estancia, String descripcion, String dni, String cif) {
		this.jdbcTemplate.update(
				"update estancia set descripcion = ?, dni=?, cif=? where id_estancia=?", descripcion,dni,cif,id_estancia);
		
	}

}
