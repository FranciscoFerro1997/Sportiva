package logica;


import java.util.LinkedList;

public class Sucursal {
	
	private String id_sucursal;
	private Direccion direccion;
	private Deposito deposito;
	private Encargado encargado;
	private Gerente gerente;
	private LinkedList<Vendedor> vendedores;
	
	
	public Sucursal (String id, Direccion d, Deposito de, Encargado e, Gerente g, LinkedList<Vendedor> lista) {
		id_sucursal=id;
		direccion=d;
		deposito=de;
		encargado=e;
		gerente=g;
		vendedores= new LinkedList<>(lista);
		
	}


	public String getId_sucursal() {
		return id_sucursal;
	}


	public void setId_sucursal(String id_sucursal) {
		this.id_sucursal = id_sucursal;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public Deposito getDeposito() {
		return deposito;
	}


	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}


	public Encargado getEncargado() {
		return encargado;
	}


	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}


	public Gerente getGerente() {
		return gerente;
	}


	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}


	public LinkedList<Vendedor> getVendedores() {
		return vendedores;
	}


	public void setVendedores(LinkedList<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}


	@Override
	public String toString() {
		return "\nInformacion de la sucursal: \nid_sucursal: " + id_sucursal + "\ndireccion: " + direccion + "\ndeposito: " + deposito
				+ "\nencargado: " + encargado + "\ngerente: " + gerente + "\nvendedores: " + vendedores;
	}
	
	
	
	
	
	
	
	

}
