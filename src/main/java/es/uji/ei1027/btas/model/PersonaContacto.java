package es.uji.ei1027.btas.model;

public class PersonaContacto extends Persona{

	private String apellidos;
	private Empresa empresa;
	private Estancia estancia;


	public PersonaContacto() {
		super();
	}

	public PersonaContacto(String dni, Direccion direccion, String nombre,String apellidos, String telefono, String email, Empresa empresa, Estancia estancia ) {
		super( dni,  direccion,  nombre,  telefono, email );
		this.apellidos=apellidos;
		this.empresa= empresa;
		this.estancia=estancia;
	}
	public PersonaContacto(PersonaContacto personaContacto) {
		super(personaContacto);
		this.apellidos=personaContacto.apellidos;
		this.empresa= personaContacto.empresa;
		this.estancia=personaContacto.estancia;
	}
}
