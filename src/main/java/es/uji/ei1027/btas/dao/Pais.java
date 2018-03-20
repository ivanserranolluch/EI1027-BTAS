package es.uji.ei1027.btas.dao;

public class Pais {
	
	String nom;
	String capital;
		
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; } 
	public String getCapital() { return capital; }
	public void setCapital(String capital) { this.capital = capital; } 
	
	@Override
	public String toString() {
		return "Pais [nom=" + nom + ", capital=" + capital + "]";
	} 

}
