package logica;

public class Sucursal {
	
	String id_sucursal;
	Direccion direccion;
	Deposito deposito;
	Encargado encargado;
	Gerente gerente;
	Vendedor vendedores[] = new Vendedor[8];
	
	
	public Sucursal (String id, Direccion d, Deposito de, Encargado e, Gerente g, Vendedor v) {
		id_sucursal=id;
		direccion=d;
		deposito=de;
		encargado=e;
		gerente=g;
		vendedores[0]=v;
		
	}
	
	
	
	
	
	

}
