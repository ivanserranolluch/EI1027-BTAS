package es.uji.ei1027.btas.model;

public class CP {

	private Integer cp;
	private String ciudad;
	private String pais;
	
	public CP(){
		super();
	}
	
	public CP(Integer cp, String ciudad, String pais){
		this.cp=cp;
		this.ciudad=ciudad;
		this.pais=pais;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
