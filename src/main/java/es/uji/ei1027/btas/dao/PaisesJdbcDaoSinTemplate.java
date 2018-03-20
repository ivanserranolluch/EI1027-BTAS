package es.uji.ei1027.btas.dao;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class PaisesJdbcDaoSinTemplate implements PaisesDAO {
	private final static Logger Log = Logger.getLogger(PaisesJdbcDaoSinTemplate.class.getName()); 
    
	@Autowired 
	DataSource dataSource;
	
	
	public List<Pais> getPaises() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			if (conn==null)
				Log.severe("JDBC no trobat");
		}
		catch (SQLException e) {
			Log.severe("Error creant connexio JDBC");
			e.printStackTrace();
			return null;
		}
		List<Pais> paises = new ArrayList<Pais>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select pais,capital from pais");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Pais pais = new Pais();
				pais.setNom(rs.getString("pais"));
				pais.setCapital(rs.getString("capital"));
				paises.add(pais);
			}
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
			return null;
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
				Log.warning("Error tancant connexio JDBC");				
				e.printStackTrace();
			}
		}
		return paises;
	}
	
	public Pais getPais(String nom) {
		Connection conn = null;
		try { 
			conn = dataSource.getConnection();
			if (conn==null)
				Log.severe("JDBC no trobat");
		}
		catch (SQLException e) {
			Log.severe("Error creant connexio JDBC");
			e.printStackTrace();
			return null;
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pais pais = new Pais();
		try {
			stmt = conn.prepareStatement("select pais, capital from pais where pais=?");
			
			stmt.setString(1,nom);
			
			rs= stmt.executeQuery();
			rs.next();
			pais.setNom(rs.getString("pais"));
			pais.setCapital(rs.getString("capital"));
			} 
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
			return null;
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
				Log.warning("Error tancant connexio JDBC");				
				e.printStackTrace();
			}
		}
		return pais;
	}
	
	public void addPais(Pais pais) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			if (conn==null)
				Log.severe("JDBC no trobat");
		}
		catch (SQLException e) {
			Log.severe("Error creant connexio JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			 stmt = conn.prepareStatement(
					"insert into Pais(pais, capital) "
					+ "values(?, ?)");
			stmt.setString(1, pais.getNom());
			stmt.setString(2, pais.getCapital());
			stmt.execute();	
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
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
				Log.warning("Error tancant connexio JDBC");				
				e.printStackTrace();
			}
		}
	}

	public void updatePais(Pais pais) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			if (conn==null)
				Log.severe("JDBC no trobat");
		}
		catch (SQLException e) {
			Log.severe("Error creant connexio JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"update Nadador "
					+ "set capital = ?"
					+ " where nom = ?");
			stmt.setString(1, pais.getCapital());
			stmt.setString(2, pais.getNom());
			stmt.execute();	
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
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
				Log.warning("Error tancant connexio JDBC");				
				e.printStackTrace();
			}
		}
	}

	public void deletePais(Pais pais) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			if (conn==null)
				Log.severe("JDBC no trobat");
		}
		catch (SQLException e) {
			Log.severe("Error creant connexio JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("Delete from pais where nom=?");
			stmt.setString(1, pais.getNom());
			stmt.execute();	
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
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
				Log.warning("Error tancant connexio JDBC");				
				e.printStackTrace();
			}
		}
	}
}