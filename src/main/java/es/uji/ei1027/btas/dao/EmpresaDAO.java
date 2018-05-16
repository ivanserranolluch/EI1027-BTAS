package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.model.Empresa;
import es.uji.ei1027.btas.model.Estudiante;

@Repository
public class EmpresaDAO {
	
	private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) { 
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	private static final class EmpresaMapper implements RowMapper<Empresa> {  

	    public Empresa mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Empresa empresa = new Empresa();
	        empresa.setCif(rs.getString("cif"));
	        empresa.setNombre(rs.getString("nombre"));
	        empresa.setDireccion(rs.getInt("id_dir"));
	        empresa.setDireccionWeb(rs.getString("web"));
	        empresa.setEmail(rs.getString("email"));
	        empresa.setTelefono(rs.getInt("telefono"));
	        
	        return empresa;
	    }
	}
	public List<Empresa> getEmpresas() {  

		 return this.jdbcTemplate.query("select * from empresa"
				 , new 	EmpresaMapper());
	}
	
	public Empresa getEmpresa(String cif) {
		return this.jdbcTemplate.queryForObject("select * from empresa where cif=?",  new Object[] {cif}, new EmpresaMapper());
	}
	
	public void addEmpresa(Empresa empresa) {
						
		this.jdbcTemplate.update("insert into empresa(cif,id_dir,nombre,web,telefono, email) values(?, ?, ?, ?,?,?)",
				empresa.getCif(),
				empresa.getDireccion(),
				empresa.getNombre(),
				empresa.getDireccionWeb(),
				empresa.getTelefono(),
				empresa.getEmail());
	}
	public void updateEmpresa(String cif, int id_dir, String nombre, int telefono, String email, String web) {
		this.jdbcTemplate.update(
				"update Empresa set email=?,telefono=?,nombre=?,id_dir=?,web=? where cif = ?", email,telefono,nombre, id_dir,web,cif);
	
		
	}
	public void deleteEmpresa(String cif) {
		this.jdbcTemplate.update("delete from personacontacto where cif=?",cif);
		this.jdbcTemplate.update(
		        "delete from Empresa where cif = ?",
		        cif);		
	}
}
