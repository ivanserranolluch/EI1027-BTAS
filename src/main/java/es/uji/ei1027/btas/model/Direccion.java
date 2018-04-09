package es.uji.ei1027.btas.model;

public class Direccion {

	private int id_dir;
	private int cp;
	private String calle;
	private int numero;
	private String ciudad;
	
	
	public Direccion(){
		super();
	}
	
	public Direccion(int id_dir,int cp, String calle, int numero,String ciudad){
		this.id_dir=id_dir;
		this.ciudad=ciudad;
		this.cp=cp;
		this.calle=calle;
		this.numero=numero;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad=ciudad;
	}
	
	public int getIdDir() {
		return id_dir;
	}
	
	public void setIdDir(int id_dir) {
		this.id_dir=id_dir;
	}
	
	@Override
	public String toString() {
		StringBuilder st= new StringBuilder();
		st.append("Identificador: ");
		st.append(id_dir);
		st.append("\nCalle: "+calle+", numero: ");
		st.append(numero);
		st.append(".\n CP: "+cp+"\n");
		st.append("Ciudad: "+ciudad);
		
		return st.toString();
	}
	
	
}
