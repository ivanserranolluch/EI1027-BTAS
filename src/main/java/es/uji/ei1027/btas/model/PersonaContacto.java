package es.uji.ei1027.btas.model;

public class PersonaContacto{

	private String dni;
	private String cif;
	


	public PersonaContacto() {
		super();
	}
	
	public PersonaContacto(String cif) {
		this.cif=cif;
	}

	public PersonaContacto(String dni, String cif) {
		this.dni=dni;
		this.cif= cif;
		
	}
	
	public PersonaContacto(PersonaContacto personaContacto) {
		this.dni=personaContacto.dni;
		this.cif= personaContacto.cif;
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}


}
