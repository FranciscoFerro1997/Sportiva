package logica;

public class Direccion {

	private String num;
	private String calle;
	private int cp;
	private String localidad;
	
	public Direccion(String n, String c, int cp, String l) {
		num=n;
		calle=c;
		this.cp=cp;
		localidad=l;
		
	}
	
	



	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	@Override
	public String toString() {
		return "Direccion [num=" + num + ", calle=" + calle + ", cp=" + cp + ", localidad=" + localidad + "]";
	}
	
}