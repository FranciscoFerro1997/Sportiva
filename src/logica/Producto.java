package logica;

public class Producto {
	private String id_producto;
	private String tipo_producto;
	private String nombre;
	private double precio;
	private int cantidad;
	
	
	public Producto(String id, String tipo, String nombre, double p, int cant) {
		id_producto=id;
		tipo_producto=tipo;
		this.nombre=nombre;
		precio=p;
		cantidad=cant;
		
	}
	
	
	
	
	
	
	
	
	
	
	


	public String getId_producto() {
		return id_producto;
	}


	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}


	public String getTipo_producto() {
		return tipo_producto;
	}


	public void setTipo_producto(String tipo_producto) {
		this.tipo_producto = tipo_producto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}













	@Override
	public String toString() {
		return "\nInfo producto: \nid_producto: " + id_producto + "\ntipo_producto: " + tipo_producto + "\nnombre: " + nombre
				+ "\nprecio: " + precio + "\ncantidad: " + cantidad;
	}
	
	
	
	
	
	
	

}
