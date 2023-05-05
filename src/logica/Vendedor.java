package logica;

public class Vendedor extends Usuario {
	
	String id_vendedor;
	
	
	
	public Vendedor(String n, String dni, String e,  String c, String id) {
		super(n,dni,e,c);
		id_vendedor= id;
	}



	@Override
	public String toString() {
		return super.toString() + "\nid_vendedor: " + id_vendedor;
	}
	
	

}
