package es.uji.ei1027.btas.model;

public class Persona {


	private String dni;
	private Direccion direccion;
	private String nombre;
	private String telefono;
	private String email; 


	public Persona() {
		super();
	}

	public Persona(String dni, Direccion direccion, String nombre, String telefono, String email ) {
		this.dni = dni;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono=telefono;
		this.email = email;



	}

	public Persona(Persona persona) {
		this.dni = persona.dni;
		this.direccion = persona.direccion;
		this.nombre = persona.nombre;
		this.telefono= persona.telefono;
		this.email = persona.email;

	}





}
