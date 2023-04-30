package logica;

public class Vendedor extends Usuario {
	
	String id_vendedor;
	
	
	
	public Vendedor(String n, String dni, String e, String u, String c, String id) {
		super(n,dni,e,u,c);
		id_vendedor= id;
	}



	@Override
	public String toString() {
		return "Vendedor [id_vendedor=" + id_vendedor + "]";
	}
	
	

}
