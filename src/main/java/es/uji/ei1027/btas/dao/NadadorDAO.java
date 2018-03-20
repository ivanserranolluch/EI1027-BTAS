package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import es.uji.ei1027.btas.model.Nadador;

@Repository
@Primary
public class NadadorDAO {
	 
	private JdbcTemplate jdbcTemplate;
     
	@Autowired
	public void setDataSource(DataSource dataSource) { 
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class NadadorMapper implements RowMapper<Nadador> {  

	    public Nadador mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Nadador nadador = new Nadador();
	        nadador.setNom(rs.getString("nom"));
	        nadador.setNumFederat(rs.getString("numFederat"));
	        nadador.setEdat(rs.getInt("edat"));
	        nadador.setSexe(rs.getString("sexe"));
	        return nadador;
	    }
	}

	public List<Nadador> getNadadores() {  

		 return this.jdbcTemplate.query("select * from nadador"
, new NadadorMapper());
	}	 
		
	public Nadador getNadador(String nom) {
		return this.jdbcTemplate.queryForObject("select * from nadador where nom=?",  new Object[] {nom}, new NadadorMapper());
	}
	
	public void addNadador(Nadador nadador) {
		this.jdbcTemplate.update(
				"insert into Nadador(nom, numFederat, edat, sexe) values(?, ?, ?, ?)", nadador.getNom(), nadador.getNumFederat(),
				nadador.getEdat(), nadador.getSexe());
	}
		
	public void updateNadador(Nadador nadador) {
		this.jdbcTemplate.update(
				"update Nadador set nom = ? where edat = ?", nadador.getNom(), nadador.getEdat());
	}
		
	public void deleteNadador(String nom) {
		this.jdbcTemplate.update(
		        "delete from nadador where nom = ?",
		        nom);
	}

}



