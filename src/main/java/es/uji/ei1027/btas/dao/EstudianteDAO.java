package es.uji.ei1027.btas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.btas.model.Estudiante;

@Repository
public class EstudianteDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	private final Properties properties = new Properties();
	private Session session;
	private String password;
	private void init() {
		 
		properties.put("mail.smtp.host", "mail.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port",25);
		properties.put("mail.smtp.mail.sender","betasuji@gmail.com");
		properties.put("mail.smtp.user", "betasuji@gmail.com");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
	}
	public void sendEmail(){
		 
		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("ivanserranolluch@gmail.com"));
			message.setSubject("Prueba");
			message.setText("Texto");
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), "betasuji1");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
                        //Aqui se deberia o mostrar un mensaje de error o en lugar
                        //de no hacer nada con la excepcion, lanzarla para que el modulo
                        //superior la capture y avise al usuario con un popup, por ejemplo.
			return;
		}
		
	}
	public void sendEmailConCorreo(String correo){
		 
		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
			message.setSubject("Prueba");
			message.setText("Texto");
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), "betasuji1");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
                        //Aqui se deberia o mostrar un mensaje de error o en lugar
                        //de no hacer nada con la excepcion, lanzarla para que el modulo
                        //superior la capture y avise al usuario con un popup, por ejemplo.
			return;
		}
		
	}
    
	@Autowired
	public void setDataSource(DataSource dataSource) { 
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class EstudianteMapper implements RowMapper<Estudiante> {  

	    public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Estudiante estudiante = new Estudiante();
	        estudiante.setDni(rs.getString("dni"));
	        estudiante.setAl(rs.getString("al"));
	        estudiante.setNombre(rs.getString("nombre"));
	        estudiante.setApellidos(rs.getString("apellidos"));
	        estudiante.setTelefono(rs.getInt("telefono"));
	        estudiante.setEmail(rs.getString("email"));
	        estudiante.setItinerario(rs.getString("itinerario"));
	        estudiante.setNotaMedia(rs.getDouble("notaMedia"));
	        estudiante.setNumAsigPendiente(rs.getInt("numAsigPend"));
	        estudiante.setNumCreditosAprobados(rs.getInt("creditosAprobados"));
	        estudiante.setSemestreInicioEstancia(rs.getInt("semestreInicioEstancia"));
	        
	        return estudiante;
	    }
	}

	public List<Estudiante> getEstudiantes() {  

		 return this.jdbcTemplate.query("select * from estudiante"
, new 	EstudianteMapper());
	}	 
		
	public Estudiante getEstudiante(String dni) {
		return this.jdbcTemplate.queryForObject("select * from estudiante where dni=?",  new Object[] {dni}, new EstudianteMapper());
	}
	
	public void addEstudiante(Estudiante estudiante) {
		this.jdbcTemplate.update(
				"insert into Estudiante(dni,al,nombre,apellidos,telefono,email,itinerario,notaMedia,numAsigPend,creditosAprobados,semestreInicioEstancia) values(?, ?, ?, ?)", estudiante.getDni(), estudiante.getAl(),estudiante.getNombre(),
				estudiante.getApellidos(), estudiante.getTelefono(),estudiante.getEmail(),estudiante.getItinerario(),estudiante.getNotaMedia(),estudiante.getNumAsigPendiente(),
				estudiante.getNumCreditosAprobados(),estudiante.getSemestreInicioEstancia());
	}
	//cambia el periodo delInicio de las practicas
	public void updateEstudiante(Estudiante estudiante) {
		this.jdbcTemplate.update(
				"update Estudiante set semestreInicioEstancia = ? where dni = ?", estudiante.getSemestreInicioEstancia(), estudiante.getDni());
	}
		
	public void deleteEstudiante(String dni) {
		this.jdbcTemplate.update(
		        "delete from estudiante where dni = ?",
		        dni);
	}
	
	

}
