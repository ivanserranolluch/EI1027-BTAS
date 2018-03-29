package es.uji.ei1027.btas.dao;


import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import es.uji.ei1027.btas.model.Classificacio;


@Repository
public class ClassificacioDao {

	 
	private JdbcTemplate jdbcTemplate;
     
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class ClassificacioMapper implements RowMapper<Classificacio> { 

	    public Classificacio mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Classificacio classificacio = new Classificacio();
	        classificacio.setPosicio(rs.getInt("posicio"));
	        classificacio.setTemps(rs.getTime("temps"));
	        return classificacio;
	    }
	}
	
	public List<Classificacio> getClassificacions() {
		return this.jdbcTemplate.query(
		     	"select nom_nadador, nom_prova, posicio, temps from classificacio;", 
		     	new ClassificacioMapper());
	}
	
	public List<Classificacio> getClassificacioProva(String nomProva){
		return this.jdbcTemplate.query("SELECT * FROM classificacio WHERE nom_prova=?;", new Object[] {nomProva}, new ClassificacioMapper());
	}
}
