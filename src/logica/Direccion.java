package logica;

public class Direccion {

	private String num;
	private String calle;
	private String cp;
	private String localidad;
	
	public Direccion(String n, String c, String cp, String l) {
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
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
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
		return "\nDireccion: \nnum: " + num + "\ncalle: " + calle + "\ncodigo postal: " + cp + "\nlocalidad: " + localidad;
	}
	
}