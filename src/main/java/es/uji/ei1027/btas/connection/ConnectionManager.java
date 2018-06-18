package es.uji.ei1027.btas.connection;

import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
//algo
public class ConnectionManager {
	private final static Logger Log = Logger.getLogger(ConnectionManager.class.getName()); 
	static String url = "jdbc:postgresql://db-aules.uji.es/ei102717cmrs";
	static String driverName= "org.postgresql.Driver";
	static Connection connection=null;
	final static String JDBC_PROPERTIES = "./jdbc.properties";
		
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection != null && !connection.isClosed())
			return connection;
		Class.forName(driverName);
 		Log.fine("PostgreSQL JDBC Driver Registered!");
 		Properties props = new Properties();
 		ClassLoader loader = Thread.currentThread().getContextClassLoader();           
 		InputStream stream = loader.getResourceAsStream(JDBC_PROPERTIES);
 		if (stream == null)
 			Log.severe("Fitxer " + JDBC_PROPERTIES + " no trobat");
 		else {
 			try {
 				props.load(stream);
 			}
 			catch(IOException e) {
 	 			Log.severe("No puc llegir el fitxer" + JDBC_PROPERTIES + " " + e.getMessage());
 	 			e.printStackTrace();
 			}
 		}
		connection = DriverManager.getConnection(url, props);	 
		
		if (connection != null) {
			Log.fine("Connectat correctament!");
		} else { 
			Log.severe("La connexió ha fallat!");
		}
		return connection;
	}

}
