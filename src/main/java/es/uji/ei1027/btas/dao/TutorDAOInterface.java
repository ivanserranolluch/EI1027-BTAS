package es.uji.ei1027.btas.dao;

import java.util.List;

import es.uji.ei1027.btas.model.Tutor;
import es.uji.ei1027.btas.model.Itinerario;

public interface TutorDAOInterface {
	public List<Tutor> getTutores();
	
	public Tutor getTutor(String dni);
	
	public void addTutor(Tutor tutor);
		
	public void updateTutor(String dni, int id_dir, String nombre ,int telefono,
	String email, String departamento, String despacho);
	
	public void deleteTutor(String dni);
	
}
