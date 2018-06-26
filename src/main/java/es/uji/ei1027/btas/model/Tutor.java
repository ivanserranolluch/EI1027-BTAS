package es.uji.ei1027.btas.model;


public class Tutor extends Contacto {
	
	private String departamento;
	private String despacho;
	
	public Tutor(){super();}
	
	public Tutor(String dni, int id_dir, String nombre, int telefono, String email,String departamento,String despacho  ) {
	super(dni, id_dir,nombre,telefono,email);
	this.departamento= departamento;
	this.despacho=despacho;
	}
	public Tutor(Tutor tutor ) {
	super();
	this.departamento= tutor.departamento;
	this.despacho= tutor.despacho;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}
	
	public String getDni(){
		return super.getId();
	}
	
	public void setDni(String nuevoDni) {
		super.setId(nuevoDni);
	}
	
	public int getDireccion(){
		return super.getDireccion();
	}
	
	public String getNombre() {
		return super.getNombre();
	}
	
	public int getTelefono() {
		return super.getTelefono();
	}
	
	public String getEmail() {
		return super.getEmail();
	}
	
	public void setDireccion(int idDirNuevo) {
		super.setDirecciones(idDirNuevo);
	}
	
	public void setNombre(String nombreNuevo) {
		super.setNombre(nombreNuevo);
	}
	
	public void setTelefono(int telefonoNuevo) {
		super.setTelefono(telefonoNuevo);
	}
	
	public void setEmail(String emailNuevo) {
		super.setEmail(emailNuevo);
	}
	
}

