package es.uji.ei1027.btas.model;




public class Tutor extends Contacto {
	
	private String apellidos;
	private String departamento;
	private String despacho;
	
	public Tutor(){super();}
	
	public Tutor(String dni, Direccion direccion, String nombre,String apellidos, String telefono, String email,String departamento,String despacho  ) {
	super();
	this.apellidos = apellidos;
	this.departamento= departamento;
	this.despacho=despacho;
	}
	public Tutor(Tutor tutor ) {
	super();
	this.apellidos = tutor.apellidos;
	this.departamento= tutor.departamento;
	this.despacho= tutor.despacho;
	}

}
