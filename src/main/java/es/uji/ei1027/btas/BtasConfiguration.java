package es.uji.ei1027.btas;

import javax.activation.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import es.uji.ei1027.btas.dao.OfertaProyectoDAO;




@Configuration
public class BtasConfiguration {
	

	@Bean
	@Primary
	public OfertaProyectoDAO oferta(){
	     return new OfertaProyectoDAO();
	}

	
	/*@Bean
	public ProvaController provaController(){
		final ProvaController provaController = new ProvaController();
		provaController.setAtleta(nadador());
		return provaController;
	}*/
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return (DataSource) DataSourceBuilder.create().build();
	}

	



}
