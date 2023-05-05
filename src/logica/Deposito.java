package logica;

import java.util.ArrayList;

public class Deposito {
	private String id_deposito;
	private ArrayList<Producto> listaProductos;

	public Deposito(String id, ArrayList<Producto> lista) {
		id_deposito=id;
		listaProductos = new ArrayList<>(lista);
		
	}


	public String getId_deposito() {
		return id_deposito;
	}

	public void setId_deposito(String id_deposito) {
		this.id_deposito = id_deposito;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}


	@Override
	public String toString() {
		return "\nInfo deposito: \nid_deposito: " + id_deposito + "\nlistaProductos: " + listaProductos;
	} 
	
	/* public void agregarProductos(Producto p) {
		listaProductos.add(1,p);
		
	} */
	
	
}
