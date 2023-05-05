package logica;

import javax.swing.JOptionPane;

public class Gerente extends Usuario {
	
	private String id_gerente;
	
	
	
	public Gerente(String n, String dni, String e, String c, String id) {
		super(n,dni,e,c);
		id_gerente= id;
	}
	
	
	public void crearUsuario(String n, String dni, String e, String u, String c, String id) {
		String selec;
		do {
		selec = JOptionPane.showInputDialog("Que tipo de usuario quiere crear? \n1-vendedor \n2-gerente \n3-salir");
		} while (!selec.equalsIgnoreCase("1") && !selec.equalsIgnoreCase("2") && !selec.equalsIgnoreCase("3"));
		
		int seleccion = Integer.parseInt(selec);
		
		switch (seleccion) {
		case 1:
			n= JOptionPane.showInputDialog("Ingrese nombre completo");
			dni=JOptionPane.showInputDialog("Ingrese DNI");
			e=JOptionPane.showInputDialog("Ingrese Email");
			c= JOptionPane.showInputDialog("Ingrese contraseña");
			id=JOptionPane.showInputDialog("Ingrese id del vendedor");
			Vendedor vendedor1 = new Vendedor(n,dni,e,c,id);
			JOptionPane.showMessageDialog(null, "Usted esta creando un usuario con la siguiente informacion:\nnombre: " + n + "\nDNI: " + dni + "\nEmail: " + e  + 
				"\nContraseña: " + c + "\nid: " + id	);
			
			break;
		case 2:
			n= JOptionPane.showInputDialog("Ingrese nombre completo");
			dni=JOptionPane.showInputDialog("Ingrese DNI");
			e=JOptionPane.showInputDialog("Ingrese Email");
			c= JOptionPane.showInputDialog("Ingrese contraseña");
			id=JOptionPane.showInputDialog("Ingrese id del gerente");
			Gerente gerente1 = new Gerente(n,dni,e,c,id);
			JOptionPane.showMessageDialog(null, "Usted esta creando un usuario con la siguiente informacion:\nnombre: " + n + "\nDNI: " + dni + "\nEmail: " + e + 
					"\nContraseña: " + c + "\nid: " + id	);
			
			break;
		case 3: 
			JOptionPane.showMessageDialog(null, "Saliendo de crear usuario...");

		}
		

		
	}
	
	public void editarUsuario() {
		int opcion;
		String modificacion;
		
		opcion= Integer.parseInt(JOptionPane.showInputDialog("Que desea modificar? \n1-DNI \n2-Clave"));
		switch (opcion) {
		case 1:
			modificacion = JOptionPane.showInputDialog("Ingrese nuevo DNI de usuario");
			setDni(modificacion);
			break;

		case 2:
			modificacion = JOptionPane.showInputDialog("Ingrese nueva contraseña");
			setClave(modificacion);
			
		}
		
	}
	
	public void eliminarUsuario() {
		setNombre(null);
		setDni(null);;
		setEmail(null);;
		setClave(null);;
		setLogin(false);;
		setId_gerente(null);;
	}
	
	
	
	
	
	
	
	
	
	
	


	public String getId_gerente() {
		return id_gerente;
	}


	public void setId_gerente(String id_gerente) {
		this.id_gerente = id_gerente;
	}


	@Override
	public String toString() {
		return   super.toString() + "\nid_gerente: " + id_gerente;
	}
	
	
	
	

}
