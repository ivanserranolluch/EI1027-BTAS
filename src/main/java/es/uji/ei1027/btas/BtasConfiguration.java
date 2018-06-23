package es.uji.ei1027.btas;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import es.uji.ei1027.btas.dao.AsignacionEmpresaTutorEstudianteDAO;
import es.uji.ei1027.btas.dao.OfertaProyectoDAO;
import es.uji.ei1027.btas.dao.PreferenciasEstudianteDAO;
import es.uji.ei1027.btas.services.AsignacionEmpresaTutorEstudianteService;
import es.uji.ei1027.btas.services.AsignacionEmpresaTutorEstudianteSvc;
import es.uji.ei1027.btas.services.OfertaProyectoService;
import es.uji.ei1027.btas.services.OfertaProyectoSvc;




@Configuration
public class BtasConfiguration {
	

	@Bean
	@Primary
	public OfertaProyectoService ofertaProyectoService(){
	     return new OfertaProyectoSvc();
	}

	@Bean
	@Primary
	public PreferenciasEstudianteDAO preferencias() {
		return new PreferenciasEstudianteDAO();
	}
	
	@Bean
	@Primary
	public AsignacionEmpresaTutorEstudianteDAO getAsignacionService() {
		return new AsignacionEmpresaTutorEstudianteDAO();
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
		return  DataSourceBuilder.create().build();
	}

	



}
